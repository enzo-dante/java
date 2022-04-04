package crownhounds.learnjava;

public class OOP_Person {

    /*
        private initial state of Object's member variables/fields
     */
    private String firstName;
    private String lastName;
    private int age;

    // Object method's that are NOT static since they are shared by instances
    public String getFirstName() {
        return this.firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public int getAge() {
        return this.age;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        if(age < 0 || age > 100) {
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public boolean isTeen() {

        if(this.age > 12 && this.age < 20) {

            return true;

        }

        return false;
    }

    public String getFullName() {

        if(this.firstName.isEmpty() && this.lastName.isEmpty()) {

            return "";

        } else if(this.firstName.isEmpty()) {

            return this.lastName;

        } else if(this.lastName.isEmpty()) {

            return this.firstName;

        }

        return this.firstName + " " + this.lastName;
    }


}
