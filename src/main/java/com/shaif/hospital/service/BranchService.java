package com.shaif.hospital.service;

import java.util.List;

import com.shaif.hospital.dao.imp.BranchDaoImp;
import com.shaif.hospital.dto.Branch;

public class BranchService {
	BranchDaoImp bdi = new BranchDaoImp();
	public Branch saveBranch(int hid, Branch branch) {
		Branch b=bdi.saveBranch(hid, branch);
		if (b != null) {
			System.out.println("Branch is saved successfully");
			return b;
		} else {
			System.out.println("Branch is not saved");
			return null;
		}
	}
	public boolean deleteBranch(int bid) {
		
		boolean b = bdi.deleteBranch(bid);
		if (b) {
			System.out.println("Branch is deleted");
			return true;
		} else {
			System.out.println("Branch is not deleted");
			return false;
		}
	}
	public Branch getBranchById(int bid) {
		
		Branch b = bdi.getBranchById(bid);
		if (b != null) {
			System.out.println("Branch is found");
			return b;
		} else {
			System.out.println("Branch is not found");
			return null;
		}
	}
	
	public Branch updateBranchById(int bid, Branch branch) {

		Branch b = bdi.updateBranchById(bid, branch);
		if (b != null) {
			System.out.println("Branch is updated");
			return b;
		} else {
			System.out.println("Branch is not updated");
			return null;
		}
	}
	
	public List<Branch> getAllBranches() {
		List<Branch> branches = bdi.getAllBranches();
		if (branches != null) {
			System.out.println("Branches are found");
			return branches;
		} else {
			System.out.println("Branches are not found");
			return null;
		}
	}
}
