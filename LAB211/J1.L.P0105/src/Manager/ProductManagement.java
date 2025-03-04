package Manager;

import entity.Product;
import entity.Storekeeper;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

public class ProductManagement {

    private List<Storekeeper> storekeepers;
    private List<Product> products;

    public List<Storekeeper> getStorekeepers() {
        return storekeepers;
    }

    public void setStorekeepers(List<Storekeeper> storekeepers) {
        this.storekeepers = storekeepers;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public ProductManagement(List<Storekeeper> storekeepers, List<Product> products) {
        this.storekeepers = storekeepers;
        this.products = products;
    }

    public List<Storekeeper> addStorekeeper(Storekeeper s) {
        storekeepers.add(s);
        return storekeepers;
    }

    public int getLastIDStorekeeper() {
        return storekeepers.get(storekeepers.size() - 1).getId();
    }

    public boolean checkDuplicateID(int id) {
        //Traverse from first element to last element of list products
        for (Product p : products) {
            if (p.getId() == id) {
                return true;
            }
        }
        return false;
    }

    public boolean checkDuplicatedStorekeeper(String name) {
        //Traverse from first element to last element of list storekeepers
        for (Storekeeper store : storekeepers) {
            if (store.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public List<Product> addProduct(Product p) {
        products.add(p);
        return products;
    }

    public Storekeeper getStorekeeperByID(int id) {
        ////Traverse from first element to last element of list storekeepers
        for (Storekeeper s : storekeepers) {
            if (s.getId() == id) {
                return s;
            }
        }
        return null;
    }

    public void updateProduct(Product p, int oldID) {
        ////Traverse from first element to last element of list products
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == oldID) {
                products.set(i, p);
                break;
            }
        }
    }

    public Product getProductByID(int id) {
        ////Traverse from first element to last element of list products
        for (Product p : products) {
            if (id == p.getId()) {
                return p;
            }
        }
        return null;
    }

    public List<Product> searchProductBySth(String searchValue, int choose) {
        List<Product> searched = new ArrayList<>();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        //Traverse from first element to last element of list products
        for (Product p : products) {
            //contain enter input with name of list to search when choose = 1
            if (p.getName().toLowerCase().contains(searchValue.toLowerCase()) && choose == 1) {
                searched.add(p);
            }
            //contain enter input with category of list to search when choose = 2
            if (p.getCategory().toLowerCase().contains(searchValue.toLowerCase()) && choose == 2) {
                searched.add(p);
            }
            //contain enter input with storekeeper of list to search when choose = 3
            if (p.getStorekeeper().getName().toLowerCase().contains(searchValue.toLowerCase()) && choose == 3) {
                searched.add(p);
            }
            //contain enter input with receiptdate of list to search when choose = 4
            if (dateFormat.format(p.getReceiptDate()).contains(searchValue) && choose == 4) {
                searched.add(p);
            }
        }
        return searched;
    }

    public void sortProductList() {
        //sort product by date
//        Collections.sort(products, new Comparator<Product>() {
//            @Override
//            public int compare(Product t, Product t1) {
//                //check expdate equal with manudate
//                if (t.getExpiryDate().equals(t1.getDateOfManufacture())) {
//                    return t.getDateOfManufacture().compareTo(t1.getDateOfManufacture());
//                }
//                else {
//                    return t.getExpiryDate().compareTo(t1.getExpiryDate());
//                }
//            }
//        });
        Product product1 = null, product2 = null;
        Date expiryDate1, expiryDate2;
        Date dateOfManufacture1, dateOfManufacture2;
        //loop until end of the list product
        for (int i = 0; i <= products.size() - 1; i++) {
            product1 = products.get(i);
            expiryDate1 = product1.getExpiryDate();
            dateOfManufacture1 = product1.getDateOfManufacture();
            for (int j = i + 1; j < products.size(); j++) {
                product2 = products.get(j);
                expiryDate2 = product2.getExpiryDate();
                dateOfManufacture2 = product2.getDateOfManufacture();
                // check if expirydate1 is grate than expiry date 2
                if (expiryDate1.compareTo(expiryDate2) < 0) {
                    Collections.swap(products, i, j);

                }//check if expirydate1 is equal to expiry date 2
                else if (expiryDate1.compareTo(expiryDate2) == 0) {
                    // check if dateOfManufacture1 is grate than dateOfManufacture2
                    if (dateOfManufacture1.compareTo(dateOfManufacture2) > 0) {
                        Collections.swap(products, i, j);
                    }
                }

            }
       }
    }

}
