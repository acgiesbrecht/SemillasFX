/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasCategorias;
import com.chortitzer.lab.semillasjfx.utils.Utils;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
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
public class CategoriasController implements Initializable {

    private DaoBase<LabSemillasCategorias> daoLabSemillasCategorias = new DaoBase<>(LabSemillasCategorias.class);

    @FXML
    private TableControl<LabSemillasCategorias> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            masterTable.setController(cntlLabSemillasCategorias);
            masterTable.setRecordClass(LabSemillasCategorias.class);

            NumberColumn<LabSemillasCategorias, Integer> cId = new NumberColumn<>("id", Integer.class);
            cId.setText("ID");
            cId.setEditable(false);

            TextColumn<LabSemillasCategorias> cDescripcion = new TextColumn<>("descripcion");
            cDescripcion.setText("Descripcion");

            masterTable.addColumn(cId, cDescripcion);
            masterTable.reload();
        } catch (Exception ex) {
            ex.printStackTrace();
            Utils.showException("Error", ex.getMessage(), ex);
        }
    }

    private final TableController<LabSemillasCategorias> cntlLabSemillasCategorias = new TableController<LabSemillasCategorias>() {
        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return daoLabSemillasCategorias.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
        }

        @Override
        public List<LabSemillasCategorias> insert(List<LabSemillasCategorias> newRecords) {
            return daoLabSemillasCategorias.insert(newRecords);
        }

        @Override
        public List<LabSemillasCategorias> update(List<LabSemillasCategorias> records) {
            return daoLabSemillasCategorias.update(records);
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
                        + LabSemillasCategorias.getSelectedItem().getCode() + ") because"
                        + "\nthere are Persons refer to it!").show(getScene().getWindow());
            }
            return nochildren;
        }*/
        @Override
        public void delete(List<LabSemillasCategorias> records) {
            daoLabSemillasCategorias.delete(records);
        }
    };

}
