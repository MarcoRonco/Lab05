package it.polito.tdp.anagrammi.model;

import java.util.*;

import it.polito.tdp.anagrammi.DAO.DizionarioDAO;

public class Model {
	
	public Model(){}
	
	String p= null;
	List<String> anagrammi = new ArrayList<String>();
	DizionarioDAO dDAO = new DizionarioDAO();
	
	public List<String> risolviAnagrammi(String parola){
		
		p = parola;
		List<Character> parziale = new ArrayList<Character>();
		parziale(parziale, 0);
		return anagrammi;
	}
	
	public void parziale(List<Character> parziale, int livello) {
		
		char parz[] = p.toCharArray();
		
		if(livello!=p.length()){
			
			for(int i = 0; i<p.length(); i++){
				
				if(this.conta(this.parola(parziale),parz[i])<this.conta(p, parz[i])){
					
					parziale.add(parz[i]);
					this.parziale(parziale, livello+1);
					parziale.remove((Character)parz[i]);
				
				}
			}
			
		} else {
			
			if(!anagrammi.contains(this.parola(parziale)))
			    anagrammi.add(this.parola(parziale));
		}
	}
	
	public int conta(String a, char  x){
		
		char y[] = a.toCharArray();
		int u = 0;
		for(int i = 0; i<a.length(); i++){
			if(y[i]==x){
				u++;
			}
		}
		
		return u;
	}
	
    public String parola(List<Character> parziale){
		
    	String t = "";
		for(Character k :parziale){
			t+=k;
		}
		
		return t;
	}

    public boolean isCorrect(String anagramma){
    	return dDAO.isCorrect(anagramma);
    }
}
