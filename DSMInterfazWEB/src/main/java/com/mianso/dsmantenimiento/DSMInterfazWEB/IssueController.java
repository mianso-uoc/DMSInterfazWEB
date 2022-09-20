package com.mianso.dsmantenimiento.DSMInterfazWEB;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mianso.dsmantenimiento.DSMInterfazWEB.model.Issue;

@Controller
@RequestMapping("/issues")
public class IssueController {

	@RequestMapping("")
	public String getIssues(Model model) {
		model.addAttribute("issues", getIssuesMock());
		return "issues";
	}
	
	@RequestMapping("/{idissue}")
	public String getIssue(@PathVariable Integer idissue, Model model) {
		
		model.addAttribute("issue", getIssuesMock().get(idissue));
		return "issue";
	}
	
	private List<Issue> getIssuesMock() {
		
		List<Issue> issues = new ArrayList<Issue>();
		
		for (int i=0; i<5;i++) {
			Issue issue = new Issue("Incidencia " + i, "");
			issue.setId(i);
			issues.add(issue);
		}
		return issues;
	}

}
