interface BasicFileSystemComponent {
    public void printDetails();
    public void delete();
    public void deleteRecursively();
    public String getName();
    public int getSize();
    public String getType();
    public String getDirectory();
    public String getCreationTime();
    public int getComponentCount();
}

