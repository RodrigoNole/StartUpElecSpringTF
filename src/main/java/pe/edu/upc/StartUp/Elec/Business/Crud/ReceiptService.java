package pe.edu.upc.StartUp.Elec.Business.Crud;

import pe.edu.upc.StartUp.Elec.Model.Entity.Receipt;

import java.util.List;

public interface ReceiptService {

    public List<Receipt> getAll();
    public List<Receipt> findByMonth(String month);

    public Receipt save (Receipt receipt);

    public Receipt update (Receipt receipt);

    public void deleteById (Integer id);
}
