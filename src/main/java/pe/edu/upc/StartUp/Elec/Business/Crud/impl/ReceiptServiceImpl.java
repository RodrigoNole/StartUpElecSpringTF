package pe.edu.upc.StartUp.Elec.Business.Crud.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import pe.edu.upc.StartUp.Elec.Model.Entity.Receipt;
import pe.edu.upc.StartUp.Elec.Model.Repository.ReceiptRepository;
import pe.edu.upc.StartUp.Elec.Business.Crud.ReceiptService;

import java.util.List;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public List<Receipt> getAll() {

        return receiptRepository.findAll();
    }

    @Override
    public List<Receipt> findByMonth(String month) {

        return receiptRepository.findByMonth(month);
    }

    @Override
    public Receipt save(Receipt receipt) {

        return receiptRepository.save(receipt);
    }

    @Override
    public Receipt update(Receipt receipt) {

        return receiptRepository.save(receipt);
    }

    @Override
    public void deleteById(Integer id) {

        receiptRepository.deleteById(id);
    }

	@Override
	public JpaRepository<Receipt, Integer> getJpaRepository() {
		// TODO Auto-generated method stub
		return this.receiptRepository;
	}


}
