        How to install.
1. In Google find "Intellij Idea". In the first result found, choose "Intellij Idea Community", download and install it.
2. In Google find "jdk".
   Open the first result found > accept license agreement > choose the version depending on your operating system > download and instal.
3. Download ChromeDriver, choose the version depending on your operating system, download and install to c/windows/system32.
4. Open IntellijIdea > File > New Project.
   On the left side choose "Maven".
   On the right side in the field "Project SDK" specify the path where the downloaded jdk.
   GroupId- is a name of the organization.
   ArtifactId - is a name of the project.
   In Google find "selenium maven" > choose "Selenium Java" > choose the latest version > copy the text.
   In a  pom file past the text and add <dependencies></dependencies>.

        Google27092018 Project steps:
- Navigate to google.com in web browser.
- Enter "Selenium" into search field.
- Click on "Search" button.
- Assert number of Search results is 10 on page 1.
- Assert that each result in a list contains search term.
- Click on "2' link to switch to next page.
- Assert number of Search results is 10 on page 2.
- Assert that each result in a list contains search term.

      How to run tests vis command line.
Terminal> mvn clean install -Dgoogle27092018

