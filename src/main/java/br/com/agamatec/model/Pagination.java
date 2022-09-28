package br.com.agamatec.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Pagination {
	public int countCurrent;
	public int countTotal;
	public int pageCurrent;
	public int pageTotal;
	public int itemsPerPage;
}
