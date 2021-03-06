/*
 * @(#) $RCSfile: DatePartitionLabeler.java,v $ $Revision: 1.1 $ $Date: 2004/08/02 20:23:40 $ $Name: TableView1_3 $
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
import java.util.*;
import java.text.DateFormatSymbols;

/**
 * Provides labels for bins in a Date Partition
 * @author       J Johnson
 * @version $Revision: 1.1 $ $Date: 2004/08/02 20:23:40 $  $Name: TableView1_3 $ 
 * @since        1.0
 */
public class DatePartitionLabeler implements BinLabeler, Serializable {
  int calendarField;
  DateFormatSymbols dfs = new DateFormatSymbols();

  public DatePartitionLabeler(int calendarField) {
    this.calendarField = calendarField;
  }

  /** 
   * Return a label for the given bin in the Date partition.
   * @param binIndex the index of the bin.
   * @return a formatted label to display for the given binIndex.
   */
  public String getLabel(int binIndex) {
    String[] vals;
    switch(calendarField) {
    case Calendar.DAY_OF_MONTH :
    case Calendar.DAY_OF_YEAR :
    case Calendar.WEEK_OF_MONTH :
    case Calendar.WEEK_OF_YEAR :
      return "" + ++binIndex;
    case Calendar.DAY_OF_WEEK :
      vals = dfs.getShortWeekdays();
      if (binIndex >= 0 && binIndex < vals.length) {
        return vals[binIndex];
      }
      return "Other";
    case Calendar.MONTH :
      vals = dfs.getShortMonths();
      if (binIndex >= 0 && binIndex < vals.length) {
        return vals[binIndex];
      }
      return "Other";
    }
    return "" + binIndex;
  }
}
