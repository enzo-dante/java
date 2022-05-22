package com.crownhounds.learnjava;

public class Testing {

    public static void main(String[] args) {

        // ! DEBUGGING: setting BREAKPOINTS & FIELD WATCHPOINTS to monitor, manipulate, & manage app state
//        Debugging debugging = new Debugging();

        JUnitTesting jUnitTesting = new JUnitTesting();
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
class Debugging extends Notes {
        /*
            ? DEBUGGER: examine state & manage what values were passed into a method & what values returned from a method
                essential when developers don't have access to third-party source code
                    download library JAR and source code JAR
                        save: File -> Project Structure -> Libraries -> Plus Sign (+) -> select locations for both

                prod apps usually don't have debug info bc apps run slower due to extra processing required
                    * due to slower compilation, THREADING issues masked & are harder to resolve via a debugger

            ! DEBUGGING: setting BREAKPOINTS & FIELD WATCHPOINTS to monitor, manipulate, & manage app state

            ? DEBUGGING step 1: set a pre-line suspending red breakpoint(s) on the FIRST/target line in problematic method by clicking in left-gutter

                ! BREAKPOINT (red dot): suspend app up-to but before line is executed

                ! FIELD WATCHPOINTS (red-dash dot): identify code for unexpected update to an instance field variable's value by suspending onUpdate
                    alternative:
                        Run -> View Breakpoints -> Plus Icon (+) -> Java Field Watchpoints -> select Class, Instance field
                        right-click on already added FIELD WATCHPOINT -> select more

                    * Field Modification (default): suspend app EVERYTIME a FIELD WATCHPOINT is updated/modified

                    Field Access: suspend when a field watchpoint is simply used
                    remove

                    Remove Once Hit: on 1st field access, suspend app, than remove FIELD WATCHPOINT on app resume

            ? DEBUGGING step 2: run debugger by selecting debugging icon in top-right corner of the app window (ladybug) to open Debugger
                alternative: right click on main scope and select "Debug" or Ctrl-Shift-D mac shortcut

                * Variables Window: current values of the parameters passed to this method
                    the variables themselves can be expanded via dropdowns

                    ! SET VALUE: select & set variable on the fly in debugger to test app on resume
                        right-click on variable in Debugger -> Variables window
                        select "resume program" button


                * Watches Window: isolate & monitor tagged instance variables (aviator glasses icon) during debugging process
                        tag instance variables: right-click on term in Variables window and select 'Add to Watches'

                * Frames Window: execution stack trace, with dropdown for ALL THREADS & their respective states

            ? DEBUGGING step 3: use debug buttons to review & identify issue

                ! SHOW EXECUTION POINT button: return to current execution line in Debugger
                    suspended before current execution line highlighted in non-red background

                ! STEP OVER button: advance the execution point by one statement without in-statement method details
                    don't care about what happening in a method(s) in statement

                ! STEP INTO button: step into non-JDK methods called by the next statement for their details & suspend before line execution
                    care to see what is happening inside a method(s) in statement

                    * SMART STEP INTO: on statement with nested methods, select which method to step into for suspended execution details
                        Run -> Debugging Actions -> Smart Step Into -> arrow-key select method

                ! FORCE STEP INTO button: force step into ALL methods (including JDK) called by the next statement for their details & suspend before line execution

                ! STEP OUT button: debugger will run the rest of the method, return to the caller execution line, & suspend before line execution

                ! DROP FRAME button: rewind the application by 1 frame
                    app suspended before the highlighted line of code is executed

                    only local variables will be reverted;
                        good for experimenting for branching code paths

                    no update for: network traffic, database changes, & static & instance variables

                ! RUN TO CURSOR button: run the application up to the current cursor location & suspend before the execution line

            ? JAVA DEBUGGING step 4: resume program to next breakpoint OR remove breakpoints & resume program in debugger
                ! VIEW BREAKPOINTS button: view all breakpoints to remove/review a breakpoint: select red breakpoint in the left-gutter or deselect in view breakpoint window
                    alternative: Run window -> View Breakpoints

                ! RESUME PROGRAM button: run the application to completion or up to next red breakpoint
         */


    // CONSTANTS/static class variables assigned FINAL value before compilation/instantiation
    private static final String DEBUGGING = "Debugging";

    // OOP constructor that initializes the class fields on class/object instantiation
    public Debugging() {
    // ! OOP INHERITANCE: child subclass inherits class fields & methods from extending parent super-class
        super(DEBUGGING);
        getNotes();
    }

    // ! INTERFACE: uniquely implement all publicly-shared signatures for set of classes via @Override
    @Override
    public void getNotes() {
        StringUtilities utils = new StringUtilities();
        utils.buildString();

        Util.printSeparator();

        String str = "abcdefg";

        // ? DEBUGGING step 1: set a pre-line suspending red breakpoint to target line in left-gutter
        String result = utils.upperAndPrefix(utils.addSuffix(str));
        // ? DEBUGGING step 2: run debugger
        /*
            ? DEBUGGING step 3: use debugger buttons to review & identify issue
                * SMART STEP INTO: on statement with nested methods, select which method to step into for suspended execution details
         */

        Util.printSeparator();

    }

    // ! OOP COMPOSITION + INNER CLASS: logically grouped parent object that has child-object components
    class StringUtilities {

        // CONSTANTS/static class variables assigned FINAL value before instantiation
        private static final char CHARACTER = 'a';

        // ENCAPSULATION: security access-modifier private class variables WITH default values
        private StringBuilder stringBuilder = new StringBuilder();

        // ? FIELD WATCHPOINTS (red-dash dot): identify code for unexpected update to an instance field variable's value by suspending onUpdate
        private int charsAdded = 0;

        // non-static unique behavior/class methods
        public void buildString() {

            StringBuilder stringBuilder = new StringBuilder();

            while(stringBuilder.length() < 10) {
                addChar(stringBuilder, CHARACTER);
            }

            System.out.println(stringBuilder);
        }

        private void addChar(StringBuilder stringBuilder, char character) {
             // ? JAVA DEBUGGING STEPS: 1. set a pre-line suspending red breakpoint(s) on the FIRST/target line in problematic method by clicking in left-gutter
//            this.stringBuilder.append(character);

            // ? JAVA DEBUGGING STEP 2: select debugging icon in top-right corner of the app window (ladybug) to open Debugger

            /*
            ? JAVA DEBUGGING STEP 3: use debug buttons to review & identify issue
                debugger step over: shows that code is updating instance variable via 'this.stringBuilder' instead of the 'stringBuilder' argument
                    loop will never terminate, this.stringBuilder instance will continue to grow until memory-exception

                debugger step out: debugger will run the rest of the method, return to the caller execution line, & suspend before line execution

            ? JAVA DEBUGGING STEP 4: resume program to next breakpoint OR remove breakpoints & resume program in debugger
             */
            stringBuilder.append(character);
            charsAdded++;
        }

        private String upperAndPrefix(String str) {
            String upper = str.toUpperCase();
            return "Prefix__" + upper;
        }

        private String addSuffix(String str) {
            return str + "__Suffix";
        }
    }
}

// ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
class JUnitTesting extends Notes {

    // CONSTANTS/static class variables assigned FINAL value before instantiation/compilation
    private static final String JUNIT_TESTING = "JUnit Testing";

    // ENCAPSULATION security access modifiers private class fields

    // OOP constructor that initializes class fields on class/object instantiation
    public JUnitTesting() {
        // ! OOP INHERITANCE: child subclass inherits class fields & public methods from extending parent super-class
        super(JUNIT_TESTING);
        getNotes();
    }

    // non-static unique behavior/class methods
    // ! INTERFACE + OOP POLYMORPHISM: uniquely implement all signatures publicly-shared within a set of classes via @Override
    @Override
    public void getNotes() {

    }


    // getters & setters
}