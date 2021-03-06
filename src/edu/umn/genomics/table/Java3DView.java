/*
 * @(#) $RCSfile: Java3DView.java,v $ $Revision: 1.3 $ $Date: 2003/05/15 18:23:35 $ $Name: TableView1_3 $
 *
 * Center for Computational Genomics and Bioinformatics
 * Academic Health Center, University of Minnesota
 * Copyright (c) 2000-2002. The Regents of the University of Minnesota  
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 * see: http://www.gnu.org/copyleft/gpl.html
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA  02111-1307, USA.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 */


package edu.umn.genomics.table;

import java.io.Serializable;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.event.*;
import edu.umn.genomics.table.dv.*;
import edu.umn.genomics.table.dv.j3d.*;

/**
 * Java3DView provides common TableModel View elements.
 * @author       J Johnson
 * @version $Revision: 1.3 $ $Date: 2003/05/15 18:23:35 $  $Name: TableView1_3 $ 
 * @since        1.0
 * @see  ColumnMap
 * @see  TableContext
 * @see  javax.swing.table.TableModel
 * @see  javax.swing.ListSelectionModel
 */
public class Java3DView extends DvWrapper implements Serializable {

  /**
   * Constructs a view display.  Nothing will be displayed 
   * until a data model is set.
   * @see #setTableModel(TableModel tableModel)
   */
  public Java3DView() {
    super();
    init();
  }

  /**
   * Constructs a view  display which is initialized with 
   * tableModel as the data model, and a default selection model.
   * @param tableModel the data model for the parallel coordinate display
   */
  public Java3DView(TableModel tableModel) {
    super(tableModel);
    init();
  }

  /**
   * Constructs a view  display which is initialized with 
   * tableModel as the data model, and the given selection model.
   * @param tableModel the data model for the parallel coordinate display
   * @param lsm  the ListSelectionModel for the parallel coordinate display
   */
  public Java3DView(TableModel tableModel, ListSelectionModel lsm) {
    super(tableModel, lsm);
    init();
  }

  private void init() {
    dv = new DataViewJ3D();
    if (ctx != null) {
      dv.setSetOperatorModel(ctx.getSetOperator(tm));
    }
    setLayout(new BorderLayout());
    add(dv);
    setDataMap();
  }

}
