package org.nyu.crypto.controller;

import org.nyu.crypto.dto.Digraph;
import org.nyu.crypto.service.DigraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class DigraphController {

	@Autowired
	private DigraphService digraphService;

	@RequestMapping(value = "/api/digraph", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<?> generateDigraph(@RequestParam("plainText") String plainText) {
		Digraph digraph = new Digraph();
		digraph.setPlaintext(plainText);
		digraph.setDigraph(digraphService.getDigraphArray(plainText));
		return ResponseEntity.ok(digraph);
	}
}
