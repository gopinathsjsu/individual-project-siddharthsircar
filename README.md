# individual-project-siddharthsircar
individual-project-siddharthsircar created by GitHub Classroom

# Instructions to Run
1. Clone the project on your machine
2. Import the project to Eclips Workplace
3. Sample Input files, Dataset, and Cards db is in: src/main/resources/SampleFiles (More input files can be added to this location)
4. The output files are generated in the OutputFiles directory in the root folder
5. The project has a config.properties file where the Input File Name, Input files' directory and Output directory is added. 
6. To add a new input file, just update the inputFileName property in the config file with csv file name. Exclude the file extension.
7. Run the project.

OR

1. Update the config.properties with the input file name
2. Run the individualprojectjar file from the root folder

Card Sheet is maintained in src/main/resources/SampleFiles

# Design Pattern Used
The following design patterns have been used:
1. Decorator Pattern: To validate the order (Insufficient Qty / Crossing the category cap)
2. Singleton Pattern: The inventory is created using singleton pattern as a single instance is required across the application.
3. Adaptor Pattern: used to initialize the Stock and Cart.
# Class Diagram
![image](https://user-images.githubusercontent.com/24874394/144771887-44015ffa-9ec5-44a5-b4bd-df3f1d37a48a.png)

# Screenshots
## Input File 1
### Terminal
![image](https://user-images.githubusercontent.com/24874394/144774051-d2512504-ac4f-4aee-9f16-0c0121083856.png)

### Error File
![image](https://user-images.githubusercontent.com/24874394/144771992-53e77e95-3ac6-4df8-ae52-a2c5a1baa2e9.png)

## Input File 2
### Terminal
![image](https://user-images.githubusercontent.com/24874394/144774368-da232a46-e30a-4726-82a3-9425ad326f8b.png)

### Output File
![image](https://user-images.githubusercontent.com/24874394/144774445-81535a43-34ab-4414-b0a8-e5ada519a469.png)


## Input File 3
### Terminal
![image](https://user-images.githubusercontent.com/24874394/144774505-a474dd02-9b95-495c-a088-50880d180983.png)

### Success Output File
![image](https://user-images.githubusercontent.com/24874394/144774425-83c18c77-0f55-4864-8c66-d3eb2939e5c2.png)

