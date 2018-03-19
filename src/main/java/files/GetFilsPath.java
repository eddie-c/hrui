package files;

public class GetFilsPath {
    public String getPath(){
        return this.getClass().getResource("/").getPath();
    }

    public static void main(String[] args) {
        System.out.println(new GetFilsPath().getPath()+"trans01.txt");

    }
}
