package Interface;

import br.unibrasil.Product.productAbstract.ObjectData;
import br.unibrasil.util.DTOData;

public interface IWorkerConvertObject {

	DTOData getElementListPlaceHolderDTOData();
	void setListPlaceHolderObjectData(ObjectData objectData);
	boolean getContinua();

}
