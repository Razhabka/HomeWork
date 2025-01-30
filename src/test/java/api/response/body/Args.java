package api.response.body;

public class Args {
    private String foo1;
    private String foo2;

    public Args(String foo1, String foo2) {
        this.foo1 = foo1;
        this.foo2 = foo2;
    }

    public String getFoo1() {
        return foo1;
    }

    public String getFoo2() {
        return foo2;
    }
}
