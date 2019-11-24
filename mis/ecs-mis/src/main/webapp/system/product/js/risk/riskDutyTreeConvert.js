function convert(rows){    
	function exists(rows, parentId){    
        for(var i=0; i<rows.length; i++){    
            if (rows[i].id == parentId) return true;    
        }    
        return false;    
    }

	function existsChild(rows,id){
        for(var i=0; i<rows.length; i++){    
            if (rows[i].parentId == id) return true;    
        }    
        return false;   
    }
        var nodes = [];    
        // 得到顶层节点  
        for(var i=0; i<rows.length; i++){   
            var row = rows[i];    
            if (!exists(rows, row.parentId)){
            	if(existsChild(rows,row.id)){
            		 nodes.push({    
            			 id:row.id,    
                         text:row.text,
                         checked:false,
                         parentId:row.parentId,
                         code:row.code,  
                         type:row.type,
                         businessarea:row.businessarea, 
                         state:"closed"
                     });    
            	}
            	else{
            		nodes.push({    
            			 id:row.id,    
                         text:row.text,
                         checked:row.checked,
                         parentId:row.parentId,
                         code:row.code,  
                         type:row.type,
                         businessarea:row.businessarea, 
                         state:"open"                    
                    });  
            	}
            }    
        }    
        var toDo = [];    
        for(var i=0; i<nodes.length; i++){    
            toDo.push(nodes[i]);    
        }   
        while(toDo.length){    
            var node = toDo.shift();    // 父节点   
            // 得到子节点   
            
            for(var i=0; i<rows.length; i++){    
                var row = rows[i];    
                if (row.parentId == node.id){  
                	var child = null;
                	if(existsChild(rows,row.id)){
                		child = {
                            	 id:row.id,    
                                 text:row.text,
                                 checked:false,
                                 parentId:row.parentId,
                                 code:row.code,  
                                 type:row.type,
                                 businessarea:row.businessarea, 
                                 state:"closed"          
                    		};    
                	}
                	else{
                		child = {
                				 id:row.id,    
                                 text:row.text,
                                 checked:row.checked,
                                 parentId:row.parentId,
                                 code:row.code,  
                                 type:row.type,
                                 businessarea:row.businessarea, 
                                 state:"open"
                        		};   
                	}
                	 if (node.children){    
                         node.children.push(child);    
                     } else {    
                         node.children = [child];    
                     }    
                     toDo.push(child);   
                }    
            }    
        }    
        return nodes;    
    }    