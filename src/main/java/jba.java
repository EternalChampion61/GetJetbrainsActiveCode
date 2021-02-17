import online.hugesea.scholar.jba.Layout.Layout;

public class jba {
    static Layout layout = new Layout();
    public static void main(String[] args) {
        layout.setHeight(600);
        layout.setWidth(700);
        layout.setTitle("JetBrains Active Code");
        layout.initLayout();
    }
}
