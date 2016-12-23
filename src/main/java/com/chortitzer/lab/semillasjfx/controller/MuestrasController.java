/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.chortitzer.lab.semillasjfx.controller;

import com.chortitzer.lab.semillasjfx.App;
import com.chortitzer.lab.semillasjfx.DaoBase;
import com.chortitzer.lab.semillasjfx.domain.LabClientes;
import com.chortitzer.lab.semillasjfx.domain.LabMuestrasSemillas;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasCategorias;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasEspecies;
import com.chortitzer.lab.semillasjfx.domain.LabSemillasMuestreadores;
import com.chortitzer.lab.semillasjfx.utils.Utils;
import com.panemu.tiwulfx.common.TableCriteria;
import com.panemu.tiwulfx.common.TableData;
import com.panemu.tiwulfx.table.ComboBoxColumn;
import com.panemu.tiwulfx.table.LocalDateColumn;
import com.panemu.tiwulfx.table.NumberColumn;
import com.panemu.tiwulfx.table.TableControl;
import com.panemu.tiwulfx.table.TableController;
import com.panemu.tiwulfx.table.TextColumn;
import com.panemu.tiwulfx.table.TypeAheadColumn;
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
public class MuestrasController implements Initializable {

    private DaoBase<LabMuestrasSemillas> daoLabMuestrasSemillas = new DaoBase<>(LabMuestrasSemillas.class);
    private DaoBase<LabSemillasCategorias> daoLabSemillasCategorias = new DaoBase<>(LabSemillasCategorias.class);
    private DaoBase<LabSemillasEspecies> daoLabSemillasEspecies = new DaoBase<>(LabSemillasEspecies.class);
    private DaoBase<LabSemillasMuestreadores> daoLabSemillasMuestreadores = new DaoBase<>(LabSemillasMuestreadores.class);
    private DaoBase<LabClientes> daoLabClientes = new DaoBase<>(LabClientes.class);

    @FXML
    private TableControl<LabMuestrasSemillas> masterTable;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            masterTable.setController(cntlLabMuestrasSemillas);
            masterTable.setRecordClass(LabMuestrasSemillas.class);

            NumberColumn<LabMuestrasSemillas, Integer> cId = new NumberColumn<>("id", Integer.class);
            cId.setText("ID");
            cId.setRequired(true);
            cId.setSortType(TableColumn.SortType.DESCENDING);

            TextColumn<LabMuestrasSemillas> cIdentificacion = new TextColumn<>("identificacionOriginal");
            cIdentificacion.setText("Identificacion Original");

            LocalDateColumn<LabMuestrasSemillas> cFechaEntrada = new LocalDateColumn<>("fechaEntrada");
            cFechaEntrada.setText("Fecha Entrada");
            cFechaEntrada.setRequired(true);

            ComboBoxColumn<LabMuestrasSemillas, Integer> cMuestraOLote = new ComboBoxColumn<>("muestraOLote");
            cMuestraOLote.addItem("Muestra Simple", 1);
            cMuestraOLote.addItem("Muestra de Lote", 0);
            cMuestraOLote.setText("Tipo de Muestra");
            cMuestraOLote.setRequired(true);

            TextColumn<LabMuestrasSemillas> cZafra = new TextColumn<>("zafra");
            cZafra.setText("Zafra");

            TextColumn<LabMuestrasSemillas> cProcedencia = new TextColumn<>("procedencia");
            cProcedencia.setText("Procedencia");

            NumberColumn<LabMuestrasSemillas, Integer> cPesoLote = new NumberColumn<>("lotePeso", Integer.class);
            cPesoLote.setText("Peso Lote");

            TextColumn<LabMuestrasSemillas> cLoteCantidadBolsas = new TextColumn<>("loteCantidadBolsas");
            cLoteCantidadBolsas.setText("Cantidad de Bolsas");

            TypeAheadColumn<LabMuestrasSemillas, LabSemillasMuestreadores> cMuestreador = new TypeAheadColumn<>("idMuestreador");
            cMuestreador.setText("Muestreador");
            List<LabSemillasMuestreadores> lLabSemillasMuestreadores = daoLabSemillasMuestreadores.getList();
            lLabSemillasMuestreadores.forEach((p) -> {
                cMuestreador.addItem(p.getNombre(), p);
            });
            cMuestreador.setRequired(true);

            TypeAheadColumn<LabMuestrasSemillas, LabSemillasEspecies> cEspecie = new TypeAheadColumn<>("idEspecie");
            cEspecie.setText("Especie");
            List<LabSemillasEspecies> lLabSemillasEspecies = daoLabSemillasEspecies.getList();
            lLabSemillasEspecies.forEach((p) -> {
                cEspecie.addItem(p.getNombreComun(), p);
            });

            TypeAheadColumn<LabMuestrasSemillas, LabClientes> cCliente = new TypeAheadColumn<>("idCliente");
            cCliente.setText("Cliente");
            cCliente.setPrefWidth(200);
            List<LabClientes> lLabClientes = daoLabClientes.getList();
            lLabClientes.forEach((p) -> {
                cCliente.addItem(p.getNombre(), p);
            });

            TypeAheadColumn<LabMuestrasSemillas, LabSemillasCategorias> cCategoria = new TypeAheadColumn<>("idCategoria");
            cCategoria.setText("Categoria");
            List<LabSemillasCategorias> lLabSemillasCategorias = daoLabSemillasCategorias.getList();
            lLabSemillasCategorias.forEach((p) -> {
                cCategoria.addItem(p.getDescripcion(), p);
            });

            //masterTable.addColumn(cId, cIdentificacion, cFechaEntrada, cMuestraOLote, cCliente, cEspecie, cCategoria, cZafra, cProcedencia, cPesoLote, cLoteCantidadBolsas, cMuestreador);
            masterTable.addColumn(cId, cIdentificacion, cFechaEntrada, cMuestraOLote, cCliente, cEspecie, cCategoria, cZafra, cProcedencia, cLoteCantidadBolsas, cMuestreador);
            //masterTable.setMaxRecord(100);

            masterTable.reload();

        } catch (Exception ex) {
            Utils.showException(ex.toString(), ex.getMessage(), ex);
        }
    }

    private final TableController<LabMuestrasSemillas> cntlLabMuestrasSemillas = new TableController<LabMuestrasSemillas>() {
        @Override
        public TableData loadData(int startIndex, List<TableCriteria> filteredColumns, List<String> sortedColumns, List<TableColumn.SortType> sortingOrders, int maxResult) {
            return daoLabMuestrasSemillas.fetch(startIndex, filteredColumns, sortedColumns, sortingOrders, maxResult);
        }

        @Override
        public List<LabMuestrasSemillas> insert(List<LabMuestrasSemillas> newRecords) {
            return daoLabMuestrasSemillas.insert(newRecords);
        }

        @Override
        public List<LabMuestrasSemillas> update(List<LabMuestrasSemillas> records) {
            return daoLabMuestrasSemillas.update(records);
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
                        + LabMuestrasSemillas.getSelectedItem().getCode() + ") because"
                        + "\nthere are Persons refer to it!").show(getScene().getWindow());
            }
            return nochildren;
        }*/
        @Override
        public void delete(List<LabMuestrasSemillas> records) {
            daoLabMuestrasSemillas.delete(records);
        }
    };

}
