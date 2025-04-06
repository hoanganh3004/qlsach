package model;

public class Sach {
	private int masach;
    private String tensach;
    private String soluong;
    private String gia;
    //Bổ sung đường dẫn ảnh
    private String imagePath;

 // constructors
    public Sach() {}
    public Sach(String tensach, String soluong, String gia) {
    	super();
        this.tensach = tensach;
        this.soluong = soluong;
        this.gia = gia;
    }
    public Sach(int masach, String tensach, String soluong, String gia) {
    	super();
        this.masach = masach;
        this.tensach = tensach;
        this.soluong = soluong;
        this.gia = gia;
    }
    //Bổ sung constructor khi thêm ảnh
    public Sach(int masach, String tensach, String soluong, String gia, String imagePath) {
    	super();
    	this.masach = masach;
    	this.tensach = tensach;
    	this.soluong = soluong;
    	this.gia = gia;
    	this.imagePath = imagePath;
    }
    public Sach(String tensach, String soluong, String gia, String imagePath) {
    	super();
    	this.tensach = tensach;
    	this.soluong = soluong;
    	this.gia = gia;
    	this.imagePath = imagePath;
    }
    // getters and setters
    public int getmasach() {
        return masach;
    }

    public void setmasach(int masach) {
        this.masach = masach;
    }

    public String gettensach() {
        return tensach;
    }

    public void settensach(String tensach) {
        this.tensach = tensach;
    }

    public String getsoluong() {
        return soluong;
    }

    public void setsoluong(String soluong) {
        this.soluong = soluong;
    }

    public String getgia() {
        return gia;
    }

    public void setgia(String gia) {
        this.gia = gia;
    }
    //Bổ sung getters and setters khi thêm ảnh
    public String getImagePath() {
    	return imagePath;
    }
    public void setImagePath(String imagePath) {
    	this.imagePath = imagePath;
    }
	
		
}

