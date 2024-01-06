import java.util.ArrayList;

public abstract class Directory implements BasicFileSystemComponent{
    protected ArrayList<BasicFileSystemComponent> children;
    protected String name;
    protected int size;
    protected String type;
    protected String directory;
    protected String creation_time;
    protected int component_count;
    protected Directory parent;



    public Directory(String name, String type, String directory, String creation_time, Directory parent) {
        this.name = name;
        this.type = type;
        this.directory = directory;
        this.creation_time = creation_time;
        this.component_count = 0;
        this.parent = parent;
        this.children = new ArrayList<BasicFileSystemComponent>();
    }

    public abstract void add(BasicFileSystemComponent child);

    public abstract void delete();


    public abstract void deleteRecursively();


    public Directory findDirectory(String name)
    {
        for (BasicFileSystemComponent child : children) {
            if(child.getName().equals(name) && !child.getType().equals("file"))
                return (Directory) child;
            else if(child.getName().equals(name) && child.getType().equals("file"))
                System.out.println("Error: " + name + " is a file");
                return null;
        }
        System.out.println("Error: " + name + " does not exist in the current directory");
        return null;
    }

    public BasicFileSystemComponent find(String name)
    {
        for (BasicFileSystemComponent child : children) {
            if(child.getName().equals(name))
                return child;
        }
        return null;
    }

    public void listPrint()
    {
        if(this.children.isEmpty())
        {
            System.out.println("Empty Directory");
        }
        else
        {
            for (BasicFileSystemComponent child : children) {
                System.out.println(child.getName() + " type: " + child.getType() + " size: " + child.getSize()+" KB" + " creation time: " + child.getCreationTime() + " component count: " + child.getComponentCount());
            }
        }
    }

    public void setSize()
    {
        int size = 0;
        for (BasicFileSystemComponent child : children) {
            size += child.getSize();
        }
        this.size = size;
    }

    public void incrementComponentCount()
    {
        this.component_count++;
    }

    public void decrementComponentCount()
    {
        this.component_count--;
    }

    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public void setDirectory(String directory)
    {
        this.directory = directory;
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

    public Directory getParent()
    {
        return this.parent;
    }
   

    @Override
    public void printDetails(){
        System.out.println("Name: " + this.name);
        System.out.println("Type: " + this.type);
        System.out.println("Directory: " + this.directory);
        System.out.println("Creation Time: " + this.creation_time);
        System.out.println("Size: " + this.size + " KB");
        System.out.println("Component Count: " + this.component_count);
    }  

}
