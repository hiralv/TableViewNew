/*
 * @(#) $RCSfile: ColumnMapLabeler.java,v $ $Revision: 1.3 $ $Date: 2002/07/30 19:45:01 $ $Name: TableView1_3 $
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
import edu.umn.genomics.graph.*;

/**
 * ColumnMapLabeler AxisLabeler provides a formatted label for the object 
 * or value in a ColumnMap for positions along an axis. 
 *
 * @author       J Johnson
 * @version $Revision: 1.3 $ $Date: 2002/07/30 19:45:01 $  $Name: TableView1_3 $ 
 * @since        1.0
 */
public class ColumnMapLabeler implements AxisLabeler, Serializable {
  ColumnMap cm;
  int maxLen = Integer.MAX_VALUE;

  public ColumnMapLabeler(ColumnMap cm) {
    this.cm = cm;
  }
  public ColumnMapLabeler(ColumnMap cm, int maxLen) {
    this.cm = cm;
    this.maxLen = maxLen;
  }

  /** 
   * Return a label for the given value along an axis.
   * @param value the value on the axis.
   * @return a formatted label to display for the given value.
   */
  public String getLabel(double value) {
    Object obj = cm.getMappedValue(value,0);
    if ( obj != null ) {
      String s = obj.toString();
      return s.length() < maxLen ? s : s.substring(0,maxLen);
    }
    return "NULL";
  }
}
