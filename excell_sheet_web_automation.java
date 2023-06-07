	@Test
	public void excel_sheet() throws IOException, InterruptedException {

        WebDriver driver = new FirefoxDriver();
		
		// Navigate to the PCHouse login page
        
        driver.manage().window().maximize();
        // Read the Excel file
        FileInputStream fileInputStream = new FileInputStream("C:\\Users\\User\\Downloads\\Book1.xlsx");
        Workbook workbook = new XSSFWorkbook(fileInputStream);
        org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

        // Iterate over the rows in the Excel sheet
        for (Row row : sheet) {
            // Iterate over the cells in the row
            for (org.apache.poi.ss.usermodel.Cell cell : row) {
                // Check if the cell is not empty
                if (cell != null) {
                    String searchQuery = cell.getStringCellValue();

                    // Open Google search page
                    driver.get("https://www.google.com/");

                    // Find the search bar element
                    WebElement searchBox = driver.findElement(By.name("q"));

                    // Enter the search query
                    searchBox.sendKeys(searchQuery);

                    // Submit the form
                    searchBox.submit();

                    Thread.sleep(3000);
                    // Print the page title (optional)
                    System.out.println("Page Title: " + driver.getTitle());
                }
            }
        }

        // Close the browser and quit the driver
        driver.quit();
        workbook.close();
        fileInputStream.close();
       
		
	}
