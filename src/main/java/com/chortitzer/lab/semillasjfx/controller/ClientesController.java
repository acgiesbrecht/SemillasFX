/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabClientes;
import com.chortitzer.lab.semillasjfx.utils.Utils;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.table.CtaCteColumn;
import com.panemu.tiwulfx.table.NumberColumn;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TextColumn;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class ClientesController implements Initializable {

    private DaoBase<LabClientes> daoLabClientes = new DaoBase<>(LabClientes.class);

    @FXML
    private TableControl<LabClientes> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            masterTable.setController(cntlLabClientes);
            masterTable.setRecordClass(LabClientes.class);

            NumberColumn<LabClientes, Integer> cId = new NumberColumn<>("id", Integer.class);
            cId.setText("ID");
            cId.setEditable(false);

            TextColumn<LabClientes> cNombre = new TextColumn<>("nombre");
            cNombre.setText("Nombre");

            CtaCteColumn<LabClientes, Integer> cCtaCte = new CtaCteColumn<>("ctacte", Integer.class);
            cCtaCte.setText("Cta. Cte. C.Ch.");

            TextColumn<LabClientes> cDireccion = new TextColumn<>("direccion");
            cDireccion.setText("Direccion");

            NumberColumn<LabClientes, Integer> cTelefono = new NumberColumn<>("telefono", Integer.class);
            cTelefono.setText("Telefono");

            NumberColumn<LabClientes, Integer> cCedula = new NumberColumn<>("cedula", Integer.class);
            cCedula.setText("Cedula");

            masterTable.addColumn(cId, cNombre, cCtaCte, cDireccion, cTelefono, cCedula);
            masterTable.reload();
        } catch (Exception ex) {
            ex.printStackTrace();
            Utils.showException("Error", ex.getMessage(), ex);
        }
    }

    private final TableController<LabClientes> cntlLabClientes = new TableController<LabClientes>() {
        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return daoLabClientes.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
        }

        @Override
        public List<LabClientes> insert(List<LabClientes> newRecords) {
            return daoLabClientes.insert(newRecords);
        }

        @Override
        public List<LabClientes> update(List<LabClientes> records) {
            return daoLabClientes.update(records);
        }

        /*
        @Override
        public boolean canDelete(TableControl table) {

             * This checking is not perfect. If there are Persons filtered thus not
             * displayed in tblPerson, the delete is not canceled. An error will be displayed
             * along with the stack trace. The better implementation is to count the children
             * from database and ensure the result is zero.

            boolean nochildren = tblEntidades.getRecords().isEmpty();
            if (!nochildren) {
                MessageDialogBuilder.error().message("Unable to delete TblBasPrecios (code "
                        + LabClientes.getSelectedItem().getCode() + ") because"
                        + "\nthere are Persons refer to it!").show(getScene().getWindow());
            }
            return nochildren;
        }*/
        @Override
        public void delete(List<LabClientes> records) {
            daoLabClientes.delete(records);
        }
    };

}
