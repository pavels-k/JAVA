public class Ghost {
    private double age;
    private boolean isFly;

    public String say(){
        return "Бу!";
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }

    public boolean isFly() {
        return isFly;
    }

    public void setFly(boolean fly) {
        isFly = fly;
    }
}

class GhostShip extends Ghost {
    @Override
    public String say() {
        return super.say();
    }
}