<%@ taglib prefix="s" uri="/struts-tags"%>
<br>
<br>
<div class="container">
    <div class="row">
        <div class="span12">
            <div class="headblocktitle">List of genres</div>
        </div>
    </div>
    <br/>
    <div class="row">            
        <button type="button" class="btn btn-warning pull-right" onclick="document.location.href = 'usuario/nuevo';">New Genre</button>                
    </div>    
    <div  style="margin-top: 40px">      
        <div class="mainlist">
            <table border="0" cellpadding="1px" cellspacing="0px"  nowrap="nowrap"  id="example" class="table-bordered data-table table table-hover" style="border: 1px solid black;">
                <thead>
                    <tr>
                        <th class="mainlistheading" style="width: 5%" >
                            ID
                        </th>
                        <th class="mainlistheading" align="left" valign="center">
                            GENRE
                        </th>		
                        <th class="mainlistheading" style="width: 5%">
                            EDIT
                        </th>						
                        <th class="mainlistheading" style="width: 5%">
                            ELIM
                        </th>						
                    </tr>
                </thead>
                <tbody>
                    <s:iterator value="%{genreList}">
                    <tr>
                        <td>
                            <s:property value="genreId"/>
                        </td>
                        <td>
                            <s:property value="genre"/>                       
                        </td>
                        <td>
                            <a href="#"><center><i class="icon-pencil"></i></center></a>
                        </td>
                        <td>
                            <center><i class="icon-trash"></i></center>
                        </td>
                    </tr>
                    </s:iterator>
                </tbody>                
            </table>
        </div>
    </div>
</div>  