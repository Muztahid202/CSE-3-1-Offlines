public class File implements BasicFileSystemComponent {
    private String name;
    private int size;
    private String type;
    private String directory;
    private String creation_time;
    private int component_count;

    public File(String name, int size, String type, String directory, String creation_time) {
        this.name = name;
        this.size = size;
        this.type = type;
        this.directory = directory + "\\" + name;
        this.creation_time = creation_time;
        this.component_count = 0;

    }

    @Override
    public void printDetails()
    {
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("Size: " + this.size + " KB");
        System.out.println("Directory: " + this.directory);
        System.out.println("Component Count: " + this.component_count);
        System.out.println("Creation time: " + this.creation_time);
    }

    
    public void delete()
    {
        System.out.println(this.name + " has been deleted");
    }

    @Override
    public void deleteRecursively()
    {
        System.out.println(this.name + " has been deleted");
    }


    @Override
    public String getName()
    {
        return this.name;
    }

    @Override
    public int getSize()
    {
        return this.size;
    }

    @Override
    public String getType()
    {
        return this.type;
    }

    @Override
    public String getDirectory()
    {
        return this.directory;
    }

    @Override
    public String getCreationTime()
    {
        return this.creation_time;
    }

    @Override
    public int getComponentCount()
    {
        return this.component_count;
    }

  
    public void setName(String name)
    {
        this.name = name;
    }

    
    public void setSize(int size)
    {
        this.size = size;
    }

    
    public void setDirectory(String directory)
    {
        this.directory = directory;
    }
    
}
