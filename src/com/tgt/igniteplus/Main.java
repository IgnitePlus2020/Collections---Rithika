/*    * Adding Ignite Members along with their Fields
      * Method to display all the departments
            Feature Added : List all the users who have the skill given as input along with their Departments
      * Method to Create new Department
            Feature Added : Adding skillSets for a particular Department
      * Deleting a particular Department
      * Method to display all the departments
            Feature Added : List all the users who have the skill given as input along with their Departments
      * Create a Member and Add the Members to the Department
 */
package com.tgt.igniteplus;

import com.tgt.igniteplus.IgniteMembers;

import javax.swing.*;
import java.io.IOException;
import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    static Set<String> Department = new HashSet<>();
    static Set<String> skillSetNew = new HashSet<>();
    static List<IgniteMembers> igniteMembersList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int value;


        //Gautham's SkillSet
        Set<String> gauthamSkillSet = new HashSet<>();
        gauthamSkillSet.add("Java");
        gauthamSkillSet.add("SQL");
        gauthamSkillSet.add("DS");

        //Divya's SkillSet
        Set<String> divyaSkillSet = new HashSet<>();
        divyaSkillSet.add("Java");
        divyaSkillSet.add("NOSQL");
        divyaSkillSet.add("ML");

        //Amit's SkillSet
        Set<String> amitSkillSet = new HashSet<>();
        amitSkillSet.add("Linux");
        amitSkillSet.add("PSQL");
        amitSkillSet.add("Scripting");

        //Naveen's SkillSet
        Set<String> naveenSkillSet = new HashSet<>();
        naveenSkillSet.add("Chef");
        naveenSkillSet.add("React");
        naveenSkillSet.add("AI");

        //Adding Ignite Members along with their Fields
        igniteMembersList.add(new IgniteMembers("Gautham", "Vtu", 28, gauthamSkillSet,
                "Data Science"));
        igniteMembersList.add(new IgniteMembers("Divya", "TGT", 26, divyaSkillSet,
                "Data Science"));
        igniteMembersList.add(new IgniteMembers("Amit", "TMT", 25, amitSkillSet,
                "Infrastructure"));
        igniteMembersList.add((new IgniteMembers("Naveen", "DOJO", 22, naveenSkillSet,
                "Infrastructure")));


        //Adding departments
        Department.add("Data Science");
        Department.add("Infrastructure");


        do {
            int choice;
            System.out.println("Press the Option(Menu) : ");
            System.out.println("1. To display all the Departments.");
            System.out.println("2. Create a new Department.");
            System.out.println("3 .Delete a Department.");
            System.out.println("4. Display all the Members as per the department ");
            System.out.println("5. Create a Member and add the member to the department.");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    displayAllDepartments();
                    break;

                case 2:
                    createNewDepartment();
                    break;

                case 3:
                    deleteDepartment();
                    break;

                case 4:
                    displayMembers();
                    break;

                case 5:
                    createMemberAndAdd();
                    break;

            }
            System.out.println("Do you want to go back to the main menu(click 0 if required) : ");
            value = sc.nextInt();
            //value=value.toLowerCase();
        } while (value == 0);
    }


     /*Method to display all the departments
     Feature Added : List all the users who have the skill given as input along with their Departments.*/

    public static void displayAllDepartments() {
        System.out.println("The Departments are :  ");
        for (String i : Department)
            System.out.println(i);
        System.out.println("Do you want to show the departments having a particular skill (Yes or No): ");
        String answer = sc.nextLine();
        answer = answer.toLowerCase();
        int y = answer.compareTo("yes");
        if (y == 0) {
            // Entering the skill and to determine who posseses the Skill and from Which Department
            String skillInput = "";
            System.out.println("Enter the skill : ");
            skillInput = sc.nextLine();
            for (IgniteMembers i : igniteMembersList) {
                if (i.getSkillSet().contains(skillInput) || skillSetNew.contains(skillInput))
                    System.out.println(i.getName() + " has the skill " + skillInput + " belonging to the department "
                            + i.getDepartment());
            }
        }


    }

    /*Method to Create new Department
     Feature Added : Adding skillSets for a particular Department */

    public static void createNewDepartment() {
        //Creating new Department
        String newSkill = "";
        System.out.println("Enter the name of the Department : ");
        String newDepartment = sc.nextLine();
        Department.add(newDepartment);

        System.out.println("The list of departments after modifications : ");
        for (String i : Department)
            System.out.println(i);

        // Adding SkillSets for a Particular Department
        System.out.println("Do you want to add skillSets for the particular Department (Yes of No) : ");
        String answer = sc.nextLine();
        answer = answer.toLowerCase();
        int y = answer.compareTo("yes");
        if (y == 0) {

            System.out.println("Enter the choice of department(index value):");
            int j = 1;
            for (String departmentName : Department) {
                System.out.println(j + ". " + departmentName);
                j++;
            }
            String dept = "";
            int departmentChoice = sc.nextInt();
            int k = 1;
            for (String departmentName : Department) {
                if (k == departmentChoice) {
                    dept = departmentName;
                    break;
                }
                k++;
            }
            System.out.println("Enter the number of Skill sets you want to add : ");
            int numberOfSkills = sc.nextInt();
            sc.nextLine();
            System.out.println("Add the skillsets : ");

            for (int i = 0; i < numberOfSkills; i++) {
                newSkill = sc.nextLine();
                skillSetNew.add(newSkill);
                newSkill = "";
            }
            for (IgniteMembers i : igniteMembersList) {
                if (i.getDepartment().equals(dept)) {
                    System.out.println(dept + " contains " + skillSetNew + i.getSkillSet());
                    break;
                } else {
                    System.out.println(dept + " contains " + skillSetNew);
                    break;
                }

            }
        }
    }

    // Deleting a particular Department
    public static void deleteDepartment() {
        for (String i : Department)
            System.out.println(i);
        System.out.println("Enter the Department you wish to remove from the above list  :  ");
        String removeDepartment = sc.nextLine();
        Department.remove(removeDepartment);
        System.out.println("The Modified list of Departments are : ");
        for (String i : Department)
            System.out.println(i);
    }

    /*Displaying all the Members as per the Department
    Feature Added : Change the members from one Department to Another*/
    public static void displayMembers() {
        //Diplay members along with their Departments
        for (IgniteMembers i : igniteMembersList) {
            System.out.println(i.getName() + " belongs to " + i.getDepartment());
        }

        // Change the Departments of the Members
        System.out.println("Do you want to swap the members with the department(Yes of No ) : ");
        String option = sc.nextLine();
        option = option.toLowerCase();
        int y = option.compareTo("yes");
        if (y == 0) {


            System.out.println("Enter the name of the member who's department you want to change: ");
            String memberName = sc.next();

            System.out.println("Enter the choice of department(index value):");
            int j = 1;
            for (String departmentName : Department) {
                System.out.println(j + ". " + departmentName);
                j++;
            }
            String dept = "";
            int departmentChoice = sc.nextInt();
            int k = 1;
            for (String departmentName : Department) {
                if (k == departmentChoice) {
                    dept = departmentName;
                    break;
                }
                k++;
            }
            for (IgniteMembers i : igniteMembersList) {
                if (i.getName().contains(memberName))
                    i.setDepartment(dept);
            }
        }

    }


    //  Create a Member and Add the Members to the Department

    public static void createMemberAndAdd() {
        String skill = "";
        System.out.println("Enter the name of the member : ");
        String newMember = sc.nextLine();
        for (IgniteMembers i : igniteMembersList) {
            if (newMember.compareTo(i.getName()) == 0)
                System.out.println("A member already exists ");
            else
                break;      //return
        }
//        System.out.println("Enter the College name : ");
//        String collegeNew = sc.nextLine();
        System.out.println("Enter the Age : ");
        int ageNew = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the College name : ");
        String collegeNew = sc.nextLine();

        System.out.println("Enter the number of skill sets you wish to add : ");
        int number = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the skill sets : ");
        for (int i = 0; i < number; i++) {
            skill = sc.nextLine();
            skillSetNew.add(skill);
            skill = "";
        }

        for (String i : Department)
            System.out.println(i);
        System.out.println("Enter the option of the Department  : ");
        String departmentNew = sc.nextLine();
        if (Department.contains(departmentNew)) {
            igniteMembersList.add(new IgniteMembers(newMember, collegeNew, ageNew, skillSetNew, departmentNew));
            System.out.println("Added");
        } else
            System.out.println("Department given does not exist(Go to Main Menu and click on option 5 to try again )");
    }

}

/* OUTPUT

Press the Option(Menu) :
1. To display all the Departments.
2. Create a new Department.
3 .Delete a Department.
4. Display all the Members as per the department
5. Create a Member and add the member to the department.

1 <----- INPUT ENTERED

The Departments are :
Data Science
Infrastructure
Do you want to show the departments having a particular skill (Yes or No):

yes <---- INPUT ENTERED

Enter the skill :

Java <---- INPUT ENTERED

Gautham has the skill Java belonging to the department Data Science
Divya has the skill Java belonging to the department Data Science

Do you want to go back to the main menu(click 0 if required) :

0 <---- INPUT ENTERED

********** MAIN MENU ***********

2 <---- INPUT ENTERED

Enter the name of the Department :

Ai <---- INPUT ENTERED

The list of departments after modifications :
Data Science
Infrastructure
Ai

Do you want to add skillSets for the particular Department (Yes of No) :

yes <----- INPUT ENTERED

Enter the choice of department(index value):
1. Data Science
2. Infrastructure
3. Ai

3 <---- INPUT ENTERED

Enter the number of Skill sets you want to add :

2 <---- INPUT ENTERED

Add the skillsets :

Probabilty <----INPUT ENTERED
Statistics <---- INPUT ENTERED

Ai contains [Probabilty, Statistics]

Do you want to go back to the main menu(click 0 if required) :

0 <---- INPUT ENTERED

********** MAIN MENU ***********
3<---- INPUT ENTERED

Data Science
Infrastructure
Ai

Enter the Department you wish to remove from the above list  :

Ai<---- INPUT ENTERED

The Modified list of Departments are :
Data Science
Infrastructure

Do you want to go back to the main menu(click 0 if required) :

0 <---- INPUT ENTERED

********** MAIN MENU ***********

4<---- INPUT ENTERED

Gautham belongs to Data Science
Divya belongs to Data Science
Amit belongs to Infrastructure
Naveen belongs to Infrastructure

Do you want to swap the members with the department(Yes of No ) :

yes<---- INPUT ENTERED

Enter the name of the member who's department you want to change:

Gautham<---- INPUT ENTERED

Enter the choice of department(index value):
1. Data Science
2. Infrastructure

2<---- INPUT ENTERED

Do you want to go back to the main menu(click 0 if required) :

0 <---- INPUT ENTERED

********** MAIN MENU ***********

4<---- INPUT ENTERED

Gautham belongs to Infrastructure
Divya belongs to Data Science
Amit belongs to Infrastructure
Naveen belongs to Infrastructure

Do you want to swap the members with the department(Yes of No ) :

no <---- INPUT ENTERED

Do you want to go back to the main menu(click 0 if required) :

0 <---- INPUT ENTERED

********** MAIN MENU ***********
5 <---- INPUT ENTERED

Enter the name of the member :
Rithika <---- INPUT ENTERED

Enter the Age :
21<---- INPUT ENTERED

Enter the College name :
Smvit<---- INPUT ENTERED

Enter the number of skill sets you wish to add :
2<---- INPUT ENTERED

Enter the skill sets :
Java<---- INPUT ENTERED
C<---- INPUT ENTERED

Data Science
Infrastructure
Enter the option of the Department  :
Infrastructure <---- INPUT ENTERED

Added


 */



