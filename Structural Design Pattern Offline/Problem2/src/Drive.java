public class Drive extends Directory {

    public Drive(String name, String type, String directory, String creation_time, Directory parent) {
        super(name, type, directory + ":\\", creation_time, parent);
    }

    @Override
    public void add(BasicFileSystemComponent child) {
        children.add(child);
        this.incrementComponentCount();
        this.setSize();
    }
    @Override
    public void delete() {
        if (this.children.isEmpty()) {
            int index = this.parent.children.indexOf(this);
            this.parent.decrementComponentCount();
            this.parent.children.remove(index);
        } else {
            System.out.println(this.getName() + " can not be deleted because it is not empty");
        }
    }

    @Override
    public void deleteRecursively() {

        for (int i = children.size() - 1; i >= 0; i--) {
            BasicFileSystemComponent child = children.get(i);
            child.deleteRecursively();
            children.remove(child);
        }
        System.out.println(this.getName() + " has been deleted");
        this.parent.decrementComponentCount();
        this.parent.children.remove(this);


    }
}
