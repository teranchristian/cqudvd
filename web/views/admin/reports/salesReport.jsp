<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">Report on sales of movies</div>
        </div>
    </div>
    <br/>
    <div class="row">  
        <form>
        <button type="button" class="btn btn-warning pull-right" onclick="window.print()">Print</button>
        </form>
    </div>    
    <div  style="margin-top: 40px">      
        <div class="mainlist">
            <table  nowrap align="center" border="0" cellpadding="3" cellspacing="3">   
                <tr>
                    <td align="center"  >
                        <s:label value="%{msg}" ></s:label>
                    </td>
                </tr>
            </table>
            <table border="0" cellpadding="1px" cellspacing="0px"  nowrap="nowrap"  id="example" class="table-bordered data-table table table-hover" style="border: 1px solid black;">
                
                    <tr>
                        <th class="mainlistheading" align="left" valign="center">
                            Total DVD titles been sold:
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            <s:property value="value1"/>    
                        </th>						
                    </tr>
                    <tr>
                        <td>
                        Total DVDs been sold:
                        </td>
                        <td>
                            <s:property value="value2"/>    
                        </td>
                    </td>
                    </tr>
                    <tr>
                        <td>
                        Amount from DVDs sold
                        </td>
                        <td>
                            <s:property value="value7"/>
                        </td>
                    </td>
                    </tr>
                    <tr>
                        <th class="mainlistheading" align="left" valign="center">
                            Total DVD titles rented:
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            <s:property value="value3"/>    
                        </th>						
                    </tr>
                    <tr>
                        <td>
                        Total DVDs rented:
                        </td>
                        <td>
                            <s:property value="value4"/>    
                        </td>
                    </td>
                    </tr>
                    <tr>
                        <td>
                        Amount from DVDs rented
                        </td>
                        <td>
                            <s:property value="value8"/>
                        </td>
                    </td>
                    </tr>
                    
                    <tr>
                        <td>
                        Total amount from all DVDs:
                        </td>
                        <td align="center">
                            <s:property value="value7+value8"/>    
                        </td>
                    </td>
                    </tr>
            </table>
        </div>
    </div>
</div>  
<script type="text/javascript" language="javascript" src="${pageContext.request.contextPath}/public/js/adminAct.js"></script>