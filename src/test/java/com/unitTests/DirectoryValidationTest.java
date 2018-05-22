package com.unitTests;

import com.utils.DirectoryUtility;
import com.utils.FileFormatSupported;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DirectoryValidationTest {
    
    
    private static String CURRENT_PROJECT_DIRECTORY = System.getProperty("user.dir");
    private static Logger LOG = LoggerFactory.getLogger(DirectoryValidationTest.class);

        @Test
        public void testExtractFileDetailsForCSV() {
            DirectoryUtility directoryUtil = new DirectoryUtility();
            directoryUtil.extractFileInfo(CURRENT_PROJECT_DIRECTORY, FileFormatSupported.CSV);
            Assert.assertTrue(directoryUtil.getFilesInfo().size() == 2);
            LOG.info("\nTotal Number of files of CSV types: " + directoryUtil.getFilesInfo().size());
        }

        @Test
        public void testExtractFileDetailsForExcel() {
            DirectoryUtility directoryUtil = new DirectoryUtility();
            directoryUtil.extractFileInfo(CURRENT_PROJECT_DIRECTORY, FileFormatSupported.Excel);
            Assert.assertTrue(directoryUtil.getFilesInfo().size() == 2);
            LOG.info("\nTotal Number of files of XLS types = " + directoryUtil.getFilesInfo().size());
        }

        @Test
        public void testExtractFileDetailsForOthers() {
            DirectoryUtility directoryUtil = new DirectoryUtility();
            directoryUtil.extractFileInfo(CURRENT_PROJECT_DIRECTORY, FileFormatSupported.OTHERS);
            Assert.assertFalse(directoryUtil.getFilesInfo().size() == 1);
            LOG.info("\nTotal Number of files of other types = "+directoryUtil.getFilesInfo().size());
        }
    }
