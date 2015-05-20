This is the interface of weixin.

it need a private subscription id.

Now, it implement this.

1. CRD(Create, Read, Del) has finish.

2. Query by title. select * from table where title like %queryStr%.

In the future, I will do the following.

1. add the Full-text index.
   a.  Base on mysql.
   b.  Base on solr.
   c.  Base on lucene.