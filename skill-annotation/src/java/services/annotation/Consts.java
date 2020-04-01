package services.annotation;

public class Consts {

    public static final String CV_TYPE = "cv";
    public static final String COURSE_TYPE = "courseDescription";
    public static final String JOB_POST_TYPE = "jobPost";
    public static final int NOT_FOUND = -1;

    /** System property - <tt>line.separator</tt>*/
    public static final String NEW_LINE = System.getProperty("line.separator");
    /** System property - <tt>file.separator</tt>*/
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    /** System property - <tt>path.separator</tt>*/
    public static final String PATH_SEPARATOR = System.getProperty("path.separator");


    // PRIVATE //

    /**
     The caller references the constants using <tt>Consts.EMPTY_STRING</tt>,
     and so on. Thus, the caller should be prevented from constructing objects of
     this class, by declaring this private constructor.
     */
    private Consts(){
        //this prevents even the native class from
        //calling this ctor as well :
        throw new AssertionError();
    }
}

