### Web Page Processor By Steven Manikiam

#### Test
mvn clean test

#### Build & Run
mvn clean package exec:java 
-Dexec.mainClass="net.manikiam.webpageprocessor.WebPageProcessorApplication" 
-Dexec.args="'Java Map'"


##Discusion

I went a little over three hours and was not able to get as much done as I would have liked.

I managed to meet the initial requirements and got in five test.  I would have liked to get in more tests but time was a
factor.

In terms of the external libraries used, I chose three. Two for testing and one for processing webpages.

Duplication testing was very basic where I used the library name as the key in a Map.  However we could take this 
further by downloading each script and calculating the MD5 hash and using this as the key in the Map.

Although I did not add any multithreading it would make sense to create a thread for each link on the search page 
which would also process for the javascript libraries on a page.  If I had implemeted the MD5 calculation to find 
duplicates these could also be threaded.

