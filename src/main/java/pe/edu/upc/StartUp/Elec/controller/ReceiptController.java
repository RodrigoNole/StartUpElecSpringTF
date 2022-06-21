package pe.edu.upc.StartUp.Elec.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.StartUp.Elec.Business.Crud.ReceiptService;
import pe.edu.upc.StartUp.Elec.Model.Entity.Customer;
import pe.edu.upc.StartUp.Elec.Model.Entity.Receipt;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/receipts")
@SessionAttributes("{receipt}")
public class ReceiptController {

    @Autowired
    private ReceiptService receiptService;

    @GetMapping
    public String listReceipt(Model model) {
        try {
            List<Receipt> receipts = receiptService.getAll();
            model.addAttribute("receipts", receipts);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "receipts/list-receipts";
    }

    @GetMapping("new")
    public String newReceipts(Model model) {
        Receipt receipt = new Receipt();
        model.addAttribute("receipt", receipt);

        return "receipts/new-receipts";
    }

    @PostMapping("savenew")
    public String Receipt(Model model, @ModelAttribute("receipt") Receipt receipt) {
        try {
            Receipt homeSaved = receiptService.update(receipt);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "redirect:/customers";
    }

    @GetMapping("{id}/edit")
    public String editReceipt(Model model, @PathVariable("id") Integer id) {
        try {
            if (receiptService.existsById(id)) {
                Optional<Receipt> optional = receiptService.findById(id);
                model.addAttribute("receipt", optional.get());
            } else {
                return "redirect:/receipts";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "receipts/edit-receipts";
    }

    @PostMapping("{id}/update")
    public String updateReceipt(Model model, @ModelAttribute("receipt") Receipt receipt,
                                @PathVariable("id") Integer id) {
        try {
            if (receiptService.existsById(id)) {
                receiptService.update(receipt);
            } else {
                return "redirect:/receipts";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/receipts";
    }

    @GetMapping("{id}/del")
    public String deleteReceipt(Model model, @PathVariable("id") Integer id) {
        try {
            if (receiptService.existsById(id)) {
                receiptService.deleteById(id);
            } else {
                return "redirect:/receipts";
            }

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return "redirect:/receipts";
    }
}
