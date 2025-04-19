import java.io.* ;
import java.lang.reflect.Array;
import java.util.* ;

/**
 * ClassBuilder
 * 
 * This class is used to create a class with attributes, getters, setters, toString method, a default constructor and a constructor with parameters.
 * 
 * @author ZeSpatule
 * @version 1.0
 * @since 2025-04-19
 */
public class ClassBuilder {
    private static String p ;
    private static BufferedWriter writer ;
    private static String name ;
    private static Scanner scan = new Scanner(System.in) ;

    public static void main(String[] args) {
        
        System.out.print("Class name > ") ;
        name = scan.nextLine() ;
        fileCreator() ;

        try {
            writer = new BufferedWriter(new FileWriter(p)) ;
        } catch(IOException e) {
            e.printStackTrace() ;
        }

        System.out.print("Herited from ? > ") ;
        String herited = scan.nextLine() ;
        String heritedClass = "" ;
        if (!herited.equals("")) {
            heritedClass = " extends " + herited + " " ;
        }
        
        String imports = "import java.io.*;\nimport java.util.*;" ;
        
        String classHeader = "public class " + name + heritedClass + " {"  ;
        
        ArrayList<String> attributes = new ArrayList<>() ;
        ArrayList<String> types = new ArrayList<>() ;
        String attributesStr = attributesCreator(attributes, types) ;
        
        String contructor = "    public " + name + "(){\n    }" ;
        String contructorWithParams  = "";
        if (attributes.size() != 0) {
            contructorWithParams += "    public " + name + "(" ;
            for (int i = 0; i < attributes.size(); i++) {
                String attribute = attributes.get(i) ;
                String type = types.get(i) ;
                if (i == 0) {
                    contructorWithParams += type + " " + attribute ;
                } else {
                    contructorWithParams += ", " + type + " " + attribute ;
                }
            }
            contructorWithParams += ") {\n" ;
            for (int i = 0; i < attributes.size(); i++) {
                String attribute = attributes.get(i) ;
                contructorWithParams += "        this." + attribute + " = " + attribute + " ;\n" ;
            }
            contructorWithParams += "    }" ;
        }
        
        
        String getters = getterCreator(attributes, types) ;
        String setters = setterCreator(attributes, types) ;

        // String toStringFunc = "    public String toString(){\n    }" ;
        String toStringFunc = toStringCreator(attributes, types) ;

        fileWriterFunc(imports) ;
        fileWriterFunc(classHeader) ;
        fileWriterFunc(attributesStr) ;
        fileWriterFunc(contructor) ;
        if (attributes.size() != 0) {
            fileWriterFunc(contructorWithParams) ;
        }
        fileWriterFunc(getters) ;
        fileWriterFunc(setters) ;
        fileWriterFunc(toStringFunc) ;
        fileWriterFunc("}") ;
    }

    public static void fileCreator() {
        try {
            // TODO gerer les chemins pour la creation
            File f = new File(name+".java") ;
            if (f.createNewFile()) {
                System.out.println("File created");
                p = "./" + name + ".java" ;
            }
            else
                System.out.println("File already exists");
        }
        catch (Exception e) {
            System.err.println(e);
        }
    }

    public static void fileWriterFunc(String content) {
    
        try {
			writer.write(content);
            writer.newLine() ;
            writer.flush() ;
		}
        catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static String attributesCreator(List<String> attributes, List<String> types) {
        String att = "" ;
        do {
            System.out.print("Attribute name > ") ;
            att = scan.nextLine() ;
            if (!att.equals("")) {
                attributes.add(att) ;
            }
        } while (!att.equals("")) ;
        for (String attribute : attributes) {
            System.out.print("Type of " + attribute + " > ") ;
            String type = scan.nextLine() ;
            types.add(type) ;
        }

        String retour = "" ;
        for (int i = 0; i < attributes.size(); i++) {
            String attribute = attributes.get(i) ;
            String type = types.get(i) ;
            retour += "    private " + type + " " + attribute + ";\n" ;
        }

        return retour ;
    }

    public static String getterCreator(List<String> attributes, List<String> types) {
        String retour = "" ;
        for (int i = 0; i < attributes.size(); i++) {
            String attribute = attributes.get(i) ;
            String type = types.get(i) ;
            retour += "    public " + type + " get" + attribute + "() {\n" ;
            retour += "        return this." + attribute + ";\n" ;
            retour += "    }\n\n" ;
        }
        return retour ;
    }

    public static String setterCreator(List<String> attributes, List<String> types) {
        String retour = "" ;
        for (int i = 0; i < attributes.size(); i++) {
            String attribute = attributes.get(i) ;
            String type = types.get(i) ;
            retour += "    public void set" + attribute + "(" + type + " " + attribute + ") {\n" ;
            retour += "        this." + attribute + " = " + attribute + " ;\n" ;
            retour += "    }\n\n" ;
        }
        return retour ;
    }

    public static String toStringCreator(List<String> attributes, List<String> types) {
        String retour = "    public String toString() {\n        return \"Instance of " + name + " \" \n" ;
        for (int i = 0; i < attributes.size(); i++) {
            String attribute = attributes.get(i) ;
            String type = types.get(i) ;
            if (i == 0) {
                retour += "        + \"\\n" + attribute + " (" + type + ") : \" + this." + attribute + " \n" ;
            } else if (i==attributes.size()-1) {
                retour += "        + \"\\n" + attribute + " (" + type + ") : \" + this." + attribute + "\n" ;
            } else {
                retour += "        + \"\\n" + attribute + " (" + type + ") : \" + this." + attribute + " \n" ;
            }
        }
        retour += "        ;\n    }\n\n" ;
        return retour ;
    }
}