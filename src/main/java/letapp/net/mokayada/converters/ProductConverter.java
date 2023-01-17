package letapp.net.mokayada.converters;

import java.util.ArrayList;
import java.util.List;

import letapp.net.mokayada.domaine.ProductVo;
import letapp.net.mokayada.domaine.ProductVo;
import letapp.net.mokayada.entities.Product;
import letapp.net.mokayada.entities.Product;

public class ProductConverter {

	public static ProductVo toVo(Product bo) {
		ProductVo vo = new ProductVo();
		vo.setId(bo.getId());
		vo.setTitle(bo.getTitle());
		vo.setDescrition(bo.getDescrition());
		vo.setCreationDate(bo.getCreationDate());
		vo.setUpdateDate(bo.getUpdateDate());
		vo.setPhotos(AppPhotoConverter.toListVo(bo.getPhotos()));
		return vo;
	}

	public static Product toBo(ProductVo vo) {
		Product bo = new Product();
		bo.setId(vo.getId());
		bo.setTitle(vo.getTitle());
		bo.setDescrition(vo.getDescrition());
		bo.setCreationDate(vo.getCreationDate());
		bo.setUpdateDate(vo.getUpdateDate());
		bo.setPhotos(AppPhotoConverter.toListBo(vo.getPhotos()));
		return bo;
	}

	public static List<ProductVo> toListVo(List<Product> listBo) {
		List<ProductVo> listVo = new ArrayList<ProductVo>();
		listBo.forEach(bo -> {
			listVo.add(toVo(bo));
		});
		return listVo;

	}

	public static List<Product> toListBo(List<ProductVo> listVo) {
		List<Product> listBo = new ArrayList<Product>();
		listVo.forEach(vo -> {
			listBo.add(toBo(vo));
		});
		return listBo;

	}

}
