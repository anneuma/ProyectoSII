package proyctosii.uma.controllers;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import proyctosii.uma.daos.*;
import proyctosii.uma.form.ExcelUploadForm;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import proyctosii.uma.models.*;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    AlumnosDao alumnosDao;
    @Autowired
    AlumnoExpedienteDao alumnoExpedienteDao;
    @Autowired
    ExpedienteDao expedienteDao;

    @Autowired
    TitulacionDao titulacionDao;
    @Autowired
    AssignaturaDao assignaturaDao;

    @RequestMapping(value="/")
    public String home(){
    return "home";
    }
    // GET: Show upload form page.
    @RequestMapping(value = "/uploadFileExcel", method = RequestMethod.GET)
    public String uploadOneFileHandler(Model model) {
        ExcelUploadForm myUploadForm = new ExcelUploadForm();
        model.addAttribute("myUploadForm", myUploadForm);
        return "uploadExcelFile";
    }

    // POST: Do Upload
    @RequestMapping(value = "/uploadFileExcel", method = RequestMethod.POST)
    public String uploadOneFileHandlerPOST(HttpServletRequest request, //
                                           Model model, //
                                           @ModelAttribute("myUploadForm") ExcelUploadForm myUploadForm) {

        return this.doUpload(request, model, myUploadForm);
    }

    private String doUpload(HttpServletRequest request, Model model,ExcelUploadForm myUploadForm) {

        String option = myUploadForm.getOption();
        String uploadRootPath = request.getServletContext().getRealPath("upload");
        System.out.println("uploadRootPath=" + uploadRootPath);
        File uploadRootDir = new File(uploadRootPath);
        if (!uploadRootDir.exists()) {
            uploadRootDir.mkdirs();
        }
        MultipartFile[] fileDatas = myUploadForm.getFileDatas();
        List<File> uploadedFiles = new ArrayList<File>();
        List<String> failedFiles = new ArrayList<String>();

        for (MultipartFile fileData : fileDatas) {
            String name = fileData.getOriginalFilename();
            if (name != null && name.length() > 0) {
                try {
                    // Create the file at server
                    File serverFile = new File(uploadRootDir.getAbsolutePath() + File.separator + name);
                    BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
                    stream.write(fileData.getBytes());
                    stream.close();
                    uploadedFiles.add(serverFile);
                    switch (option){
                        case "0":treatExcelFileAsignatura(serverFile);break;
                        default:treatExcelFile(serverFile);
                    }
                } catch (Exception e) {
                    failedFiles.add(name);
                }
            }
        }
        model.addAttribute("description", option);
        model.addAttribute("uploadedFiles", uploadedFiles);
        model.addAttribute("failedFiles", failedFiles);
        return "uploadResult";
    }

    private void treatExcelFileAsignatura(File file) {
        try {
            OPCPackage pkg = OPCPackage.open(file);
            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            for (int i=0;i<workbook.getNumberOfSheets(); i++) {
                XSSFSheet sheet = workbook.getSheetAt(i);
                XSSFRow row;
                XSSFCell cell;
                int rows = sheet.getPhysicalNumberOfRows();

                int cols = 0;
                int tmp = 0;
                for(int j = 0; j < rows; j++) {
                    row = sheet.getRow(i);
                    if(row != null) {
                        tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                        if(tmp > cols) cols = tmp;
                    }
                }
                for(int r = 1; r < rows; r++) {
                    row = sheet.getRow(r);
                    if (row != null) {
                        try {
                            Assignatura assignatura=new Assignatura();
                            for (int c = 0; c < cols; c++) {
                                cell = row.getCell((short) c);
                                if (cell != null) {
                                    switch (c){
                                        case 1:assignatura.setOferta(cell.getStringCellValue().compareToIgnoreCase("No")==0?0:1);break;
                                        case 2:assignatura.setCodigo(Long.parseLong(cell.getStringCellValue()));break;
                                        case 3: assignatura.setReferencia(Long.parseLong(cell.getStringCellValue()));break;
                                        case 4:assignatura.setNombre(cell.getStringCellValue());break;
                                        case 5:assignatura.setCurso(cell.getStringCellValue());break;
                                        case 6:assignatura.setCreditos_teoricos(Integer.parseInt(cell.getStringCellValue()));break;
                                        case 7:assignatura.setCreditos_practicos(Integer.parseInt(cell.getStringCellValue()));break;
                                        case 8:assignatura.setCreditos_totales(Integer.parseInt(cell.getStringCellValue()));break;
                                        case 9:assignatura.setDia(cell.getStringCellValue());break;
                                        case 10:assignatura.setPlaza(0);break;
                                        case 11: assignatura.setIdiomas(cell.getStringCellValue());break;
                                    }
                               }
                            }
                            assignaturaDao.save(assignatura);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }


            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

    private void treatExcelFile(File serverFile) {
        try {
            OPCPackage pkg = OPCPackage.open(serverFile);
            XSSFWorkbook workbook = new XSSFWorkbook(pkg);
            XSSFSheet sheet = workbook.getSheetAt(0);
            XSSFRow row;
            XSSFCell cell;
            int rows = sheet.getPhysicalNumberOfRows();

            int cols = 0;
            int tmp = 0;
            for(int i = 0; i < rows; i++) {
                row = sheet.getRow(i);
                if(row != null) {
                    tmp = sheet.getRow(i).getPhysicalNumberOfCells();
                    if(tmp > cols) cols = tmp;
                }
            }

            for(int r = 5; r < rows; r++) {
                row = sheet.getRow(r);
                if (row != null) {
                    Alumno alumno = new Alumno();
                    AlumnoExpediente expediente = new AlumnoExpediente();
                    Expediente expediente1 = new Expediente();
                    Matricula matricula=new Matricula();
                    try {
                        for (int c = 0; c < cols; c++) {
                            cell = row.getCell((short) c);
                            if (cell != null) {
                                switch (c) {
                                    case 0:
                                        alumno.setDni(cell.getStringCellValue());
                                        break;
                                    case 1:
                                        alumno.setNombre(cell.getStringCellValue());
                                        break;
                                    case 2:
                                        alumno.setApellido1(cell.getStringCellValue());
                                        break;
                                    case 3:
                                        alumno.setApellido2(cell.getStringCellValue());
                                        break;
                                    case 4:
                                        expediente1.setNum_expediente(Long.parseLong(cell.getStringCellValue()));
                                        expediente.setExpedientes_NUM_EXPEDIENTE(Long.parseLong(cell.getStringCellValue()));
                                        break;
                                    case 5:
                                        matricula.setNum_archivo((long)cell.getNumericCellValue());
                                        break;
                                    case 6:
                                        alumno.setEmail_i(cell.getStringCellValue());
                                        break;
                                    case 7:
                                        alumno.setEmail_p(cell.getStringCellValue());
                                        break;
                                    case 8:
                                        alumno.setTelefono(Long.parseLong(cell.getStringCellValue().replace(" ", "")));
                                        break;
                                    case 9:
                                        alumno.setMovil(Integer.parseInt(cell.getStringCellValue().replace(" ", "")));
                                        break;
                                    case 10:
                                        alumno.setDireccion(cell.getStringCellValue());break;
                                    case 11:
                                        alumno.setLocalidad(cell.getStringCellValue());break;
                                    case 12:
                                        alumno.setProvincia(cell.getStringCellValue());
                                        break;
                                    case 13:
                                        alumno.setCp(cell.toString());
                                        break;
                                    case 14:
                                        String fecha=cell.getStringCellValue();
                                        SimpleDateFormat format=new SimpleDateFormat("dd/MM/yyyy hh:mm");
                                        Date fechaFormated=format.parse(fecha);
                                        matricula.setFechaMatricula(fechaFormated);
                                        break;
                                    case 15:
                                        matricula.setTurnoPreferente(cell.getStringCellValue());
                                        break;
                                    case 16:
                                        String groupoBrt=cell.getStringCellValue();
                                        String[] grupos=groupoBrt.split(",");
                                        break;
                                    case 17:
                                        expediente1.setNota_media_provisional((int) Double.parseDouble(cell.getStringCellValue()));
                                        break;

                                }
                            }
                        }
                        try {
                            alumno.setId(alumnosDao.findAll().size());
                            alumnosDao.save(alumno);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {
                            expedienteDao.save(expediente1);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        try {

                            expediente.setAlumno_id(alumno.getId());
                            alumnoExpedienteDao.save(expediente);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch(Exception e) {
            e.printStackTrace();
        }

    }

}
