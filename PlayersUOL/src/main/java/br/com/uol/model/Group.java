package br.com.uol.model;

public enum Group {
	Vingadores("0"), LigaDaJustica("1");

	private String id;

	private Group(String id) {
		this.id = id;
		// TODO Auto-generated constructor stub
	}

	public String getId() {
		return id;
	}
	

	public static Group fromValue(String id) {
		for(Group g: values()) {
			if(g.id.equals(id)) {
				return g;
			}
		}
		throw new IllegalArgumentException("Unknown enum type: " + id);
	}
	
	

}
