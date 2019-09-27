package service;

import java.util.List;

import entity.Reader;

public class ReaderServiceImpl extends BaseService<Reader> implements ReaderService{

	@Override
	public Reader verify(long id, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Reader getReaderById(long id) {
		Reader reader = this.getDao().getSingle("id", id);
		return reader;
	}

	@Override
	public Reader getReaderByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Reader> getAllReader() {
		List<Reader> readers = this.getDao().findAll();
		return readers;
	}

	@Override
	public void mergeReader(Reader reader) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void pass(long id) {
		Reader reader = getReaderById(id);
		reader.setCheckState(true);
		this.getDao().merge(reader);
		
	}

	@Override
	public List<Reader> getReaderCheckStateIsFalse() {
		List<Reader> readers = this.getDao().findBy("checkState", false);
		return readers;
	}

}
