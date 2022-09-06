package com.gmail.jobstest18.fileDowload;

import com.codeborne.pdftest.PDF;
import com.codeborne.pdftest.matchers.ContainsExactText;
import com.codeborne.xlstest.XLS;
import com.opencsv.CSVReader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.LIST;

public class SelenideDownloadTest {

    ClassLoader cl = SelenideDownloadTest.class.getClassLoader();

    @Test
    @Disabled
    void downloadTest1() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File textFile = $("#raw-url").download();
        InputStream is = new FileInputStream(textFile);
        try {
            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            org.assertj.core.api.Assertions.assertThat(strContent).contains("JUnit 5");
        } finally {
            is.close();
        }
    }

    @Test
    @Disabled
    void downloadTest2() throws IOException {
        open("https://github.com/junit-team/junit5/blob/main/README.md");
        File textFile = $("#raw-url").download();
        try (InputStream is = new FileInputStream(textFile)) {
            byte[] fileContent = is.readAllBytes();
            String strContent = new String(fileContent, StandardCharsets.UTF_8);
            assertThat(strContent).contains("JUnit 5");
        }
    }

    @Test
    @Disabled
    void pdfParsingTest() throws Exception {
        InputStream stream = cl.getResourceAsStream("pdf/Memo_Sochi.pdf");
        PDF pdf = new PDF(stream);
        Assertions.assertEquals(5, pdf.numberOfPages);
        org.hamcrest.MatcherAssert.assertThat(pdf, new ContainsExactText("Страховой полис"));
    }

    @Test
    @Disabled
    void xlsParsingTest() throws Exception {
        InputStream stream = getClass().getClassLoader().getResourceAsStream("xls/file.xls");
        XLS xls = new XLS(stream);
        String stringCellValue = xls.excel.getSheetAt(0).getRow(5).getCell(1).getStringCellValue();
        org.assertj.core.api.Assertions.assertThat(stringCellValue).contains("Nereida");
    }

    @Test
    @Disabled
    void csvParsingTest() throws Exception {
        try (InputStream stream = getClass().getClassLoader().getResourceAsStream("resources/csv/teachers.csv");
             CSVReader reader = new CSVReader(new InputStreamReader(stream, StandardCharsets.UTF_8))){

            List<String[]> content = reader.readAll();
            org.assertj.core.api.Assertions.assertThat(content).contains(
                    new String[]{"Name", "Surname"},
                    new String[]{"Vladimir", "Parfionov"},
                    new String[]{"Test", "Testov"}
            );
        }
    }

    @Test
    @Disabled
    void zipParsingTest() throws Exception {
        ZipFile zf = new ZipFile(new File("src/test/resources/zip/Telegram Desktop.zip"));
        ZipInputStream is = new ZipInputStream(cl.getResourceAsStream("zip/Telegram Desktop.zip"));
        ZipEntry entry;
        while ((entry = is.getNextEntry()) != null) {
            org.assertj.core.api.Assertions.assertThat(entry.getName()).isEqualTo("памятка для туриста по отдыху.docx");
        }
    }
}
