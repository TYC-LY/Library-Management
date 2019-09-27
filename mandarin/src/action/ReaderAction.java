package action;

import java.util.List;

import org.apache.struts2.util.SubsetIteratorFilter.Decider;

import entity.Reader;
import service.ReaderService;


public class ReaderAction extends BaseAction<Reader,ReaderService>{

	private static final long serialVersionUID = 1L;

	private Reader Reader;
	 
	 private List<Reader> Readers;
	 
	 public Decider getCheckStateDecider() {
	      return new Decider() {
	         public boolean decide(Object element) throws Exception {
	            Reader Reader = (Reader)element;
	            return !Reader.isCheckState();
	         }
	      };
	   }
	
	 public String pass(){
		 long id = this.getModel().getId();
		 this.getService().pass(id);
		 return SUCCESS;
	 }
	 
	 public String checkReader() {
		 this.Readers = this.getService().getReaderCheckStateIsFalse();
		 return SUCCESS;
	 }

	public Reader getReader() {
		return Reader;
	}

	public void setReader(Reader reader) {
		Reader = reader;
	}

	public List<Reader> getReaders() {
		return Readers;
	}

	public void setReaders(List<Reader> readers) {
		Readers = readers;
	}
}
