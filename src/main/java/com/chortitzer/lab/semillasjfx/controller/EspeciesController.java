/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.App;
import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasEspecies;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.table.NumberColumn;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TextColumn;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;

/**
 * FXML Controller class
 *
 * @author adriang
 */
public class EspeciesController implements Initializable {

    private DaoBase<LabSemillasEspecies> daoLabSemillasEspecies = new DaoBase<>(LabSemillasEspecies.class);

    @FXML
    private TableControl<LabSemillasEspecies> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            masterTable.setController(cntlLabSemillasEspecies);
            masterTable.setRecordClass(LabSemillasEspecies.class);

            NumberColumn<LabSemillasEspecies, Integer> cId = new NumberColumn<>("id", Integer.class);
            cId.setText("ID");
            cId.setEditable(false);

            TextColumn<LabSemillasEspecies> cEspecie = new TextColumn<>("especie");
            cEspecie.setText("Especie");

            TextColumn<LabSemillasEspecies> cVariedad = new TextColumn<>("variedad");
            cVariedad.setText("Variedad");

            TextColumn<LabSemillasEspecies> cNombreComun = new TextColumn<>("nombreComun");
            cNombreComun.setText("Nombre Comun");

            masterTable.addColumn(cId, cEspecie, cVariedad, cNombreComun);
            masterTable.reload();
        } catch (Exception ex) {
            App.showException(Thread.currentThread().getStackTrace()[1].getMethodName(), ex.getMessage(), ex);
        }
    }

    private final TableController<LabSemillasEspecies> cntlLabSemillasEspecies = new TableController<LabSemillasEspecies>() {
        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return daoLabSemillasEspecies.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
        }

        @Override
        public List<LabSemillasEspecies> insert(List<LabSemillasEspecies> newRecords) {
            return daoLabSemillasEspecies.insert(newRecords);
        }

        @Override
        public List<LabSemillasEspecies> update(List<LabSemillasEspecies> records) {
            return daoLabSemillasEspecies.update(records);
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
                        + LabSemillasEspecies.getSelectedItem().getCode() + ") because"
                        + "\nthere are Persons refer to it!").show(getScene().getWindow());
            }
            return nochildren;
        }*/
        @Override
        public void delete(List<LabSemillasEspecies> records) {
            daoLabSemillasEspecies.delete(records);
        }
    };

}
