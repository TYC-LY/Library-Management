package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.opensymphony.xwork2.ActionContext;

import entity.Reader;
import entity.Record;
import service.RecordService;

public class RecordAction extends BaseAction<Record, RecordService> {

	private static final long serialVersionUID = 1L;
	private List<Record> recordTable;
	private List<Record> currentTable;
	private List<Record> historyTable;

	public String getCurrentBorrowed() throws Exception {
		System.out.println("bbbbb");
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		setRecordTable(this.getService().getRecordByReader(reader));
		currentTable = new ArrayList<Record>();
		for (int i = 0; i < recordTable.size(); i++) {
			if (recordTable.get(i).getReturnDate() == null) {
				currentTable.add(recordTable.get(i));
			}
		}
		System.out.println("aaaaa");
		return INPUT;
	}
	
	public String getBorrowHistory() throws Exception {
		System.out.println("bbbbb");
		Map<String, Object> session = ActionContext.getContext().getSession();
		Reader reader = (Reader) session.get("reader");
		setRecordTable(this.getService().getRecordByReader(reader));
		historyTable = new ArrayList<Record>();
		for (int i = 0; i < recordTable.size(); i++) {
			if (recordTable.get(i).getReturnDate() != null) {
				historyTable.add(recordTable.get(i));
			}
		}
		System.out.println("aaaaa");
		return INPUT;
	}

	// recordTable
	public List<Record> getRecordTable() {
		return recordTable;
	}

	public void setRecordTable(List<Record> recordTable) {
		this.recordTable = recordTable;
	}

	// currentTable
	public List<Record> getCurrentTable() {
		return currentTable;
	}

	public void setCurrentTable(List<Record> currentTable) {
		this.currentTable = currentTable;
	}

	// historyTable
	public List<Record> getHistoryTable() {
		return historyTable;
	}

	public void setHistoryTable(List<Record> historyTable) {
		this.historyTable = historyTable;
	}
}
