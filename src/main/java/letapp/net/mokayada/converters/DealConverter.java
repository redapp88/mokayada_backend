package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.DealVo;
import letapp.net.mokayada.entities.Deal;

public class DealConverter {

	
		public static DealVo toVo(Deal bo) {
			DealVo vo = new DealVo();
			vo.setId(bo.getId());
			vo.setOffer(OfferConverter.toVo(bo.getOffer()));
			vo.setProposal(ProposalConverter.toVo(bo.getProposal()));
			return vo;
		}

		public static Deal toBo(DealVo vo) {
			Deal bo = new Deal();
			bo.setId(vo.getId());
			bo.setOffer(OfferConverter.toBo(vo.getOffer()));
			bo.setProposal(ProposalConverter.toBo(vo.getProposal()));
			return bo;
		}

		public static List<DealVo> toListVo(List<Deal> listBo) {
			List<DealVo> listVo = new ArrayList<DealVo>();
			listBo.forEach(bo -> {
				listVo.add(toVo(bo));
			});
			return listVo;

		}

		public static List<Deal> toListBo(List<DealVo> listVo) {
			List<Deal> listBo = new ArrayList<Deal>();
			listVo.forEach(vo -> {
				listBo.add(toBo(vo));
			});
			return listBo;

		}

}
