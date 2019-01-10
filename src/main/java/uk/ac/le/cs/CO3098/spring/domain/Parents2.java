package uk.ac.le.cs.CO3098.spring.domain;


public class Parents2 {
	int id;
	Parents2 m;
	Parents2 f;
	

	public void addM(Parents2 node){
        if (m == null) {
        	 if(node.getm()!=null) {
             	m = new Parents2(node.getId(),node.getf(),node.getm());
             }
             else m = new Parents2(node.getId());
//        m.addM(node);
        }
     }
	
	
	@Override
	public String toString() {
		String newline="\n";
		return "{ "+newline+"key:" + id + ","+newline+"parents:{ m:{ \n" + m + ", f:{ \n" + f + "}\n}\n}";
	}
	
	
	public void addF(Parents2 node){
        if (f== null) {
//        f.addF(node);
        if(node.getf()!=null) {
        	f = new Parents2(node.getId(),node.getf(),node.getm());
        }
        else f = new Parents2(node.getId());
        }
        

     }
	

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	

	public Parents2 getm() {
		return m;
	}
	public void setm(Parents2 m) {
		this.m = m;
	}
	

	public Parents2 getf() {
		return f;
	}
	public void setf(Parents2 f) {
		this.f = f;
	}
	

	public Parents2(int id) {
		this.id =id;
	}


	public Parents2(Integer id2, Parents2 getf, Parents2 getm) {
	}
}

