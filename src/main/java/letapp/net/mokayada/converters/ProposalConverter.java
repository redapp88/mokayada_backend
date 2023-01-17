package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.ProductVo;
import letapp.net.mokayada.domaine.ProposalVo;
import letapp.net.mokayada.domaine.ProposalVo;
import letapp.net.mokayada.entities.Product;
import letapp.net.mokayada.entities.Proposal;
import letapp.net.mokayada.entities.Proposal;

public class ProposalConverter {

	
		public static ProposalVo toVo(Proposal bo) {
			ProposalVo vo = new ProposalVo();
			vo = (ProposalVo) OfferConverter.toVo(bo);
			vo.setOffer(OfferConverter.toVo(bo.getOffer()));
			return vo;
		}

		public static Proposal toBo(ProposalVo vo) {
			Proposal bo = new Proposal();
			bo = (Proposal) OfferConverter.toBo(vo);
			bo.setOffer(OfferConverter.toBo(vo.getOffer()));
			return bo;
		}

		public static List<ProposalVo> toListVo(List<Proposal> listBo) {
			List<ProposalVo> listVo = new ArrayList<ProposalVo>();
			listBo.forEach(bo -> {
				listVo.add(toVo(bo));
			});
			return listVo;

		}

		public static List<Proposal> toListBo(List<ProposalVo> listVo) {
			List<Proposal> listBo = new ArrayList<Proposal>();
			listVo.forEach(vo -> {
				listBo.add(toBo(vo));
			});
			return listBo;

		
	}

}
