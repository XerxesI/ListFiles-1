public class MainClass {
    public static void main(String[] args){

        System.out.println("Hello World");
        //Get individual properties
        System.out.println(PropertiesCache.getInstance().getProperty("filepath"));
        System.out.println(PropertiesCache.getInstance().getProperty("username"));

        //All property names
        System.out.println(PropertiesCache.getInstance().getAllPropertyNames());

    }
}
