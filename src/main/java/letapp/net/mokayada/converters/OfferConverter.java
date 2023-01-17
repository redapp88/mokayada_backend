package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.OfferVo;
import letapp.net.mokayada.entities.Offer;

public class OfferConverter {
	public static OfferVo toVo(Offer bo) {
		OfferVo vo = new OfferVo();
		vo.setId(bo.getId());
		vo.setTitle(bo.getTitle());
		vo.setDescription(bo.getDescription());
		vo.setCreationDate(bo.getCreationDate());
		vo.setProducts(ProductConverter.toListVo(bo.getProducts()));
		if (bo.getUser() != null)
			vo.setUser(AppUserConverter.toVo(bo.getUser()));
		vo.setProposales(ProposalConverter.toListVo(bo.getProposales()));
		vo.setDeal(DealConverter.toVo(bo.getDeal()));
		return vo;
	}

	public static Offer toBo(OfferVo vo) {
		Offer bo = new Offer();
		bo.setId(vo.getId());
		bo.setTitle(vo.getTitle());
		bo.setDescription(vo.getDescription());
		bo.setCreationDate(vo.getCreationDate());
		bo.setProducts(ProductConverter.toListBo(vo.getProducts()));
		if (bo.getUser() != null)
			vo.setUser(AppUserConverter.toVo(bo.getUser()));
		vo.setProposales(ProposalConverter.toListVo(bo.getProposales()));
		vo.setDeal(DealConverter.toVo(bo.getDeal()));
		return bo;
	}

	public static List<OfferVo> toListVo(List<Offer> listBo) {
		List<OfferVo> listVo = new ArrayList<OfferVo>();
		listBo.forEach(bo -> {
			listVo.add(toVo(bo));
		});
		return listVo;

	}

	public static List<Offer> toListBo(List<OfferVo> listVo) {
		List<Offer> listBo = new ArrayList<Offer>();
		listVo.forEach(vo -> {
			listBo.add(toBo(vo));
		});
		return listBo;

	}
}
