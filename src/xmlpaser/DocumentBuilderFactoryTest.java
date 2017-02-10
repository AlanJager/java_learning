import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.*;

/**
 * Created by AlanJager on 2016/11/30.
 */
public class DocumentBuilderFactoryTest {
    public static void main(String[] args) {
        try {
            final Document xml = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(Main.class.getResourceAsStream("/actions.xml"));

            Reader reader = new Reader();
            reader.load(new Entry(xml.getDocumentElement()));

        } catch (final IOException e) {

        } catch (final SAXException e) {

        }catch (final ParserConfigurationException e) {

        }
    }

    static class Entry {

        private Element element;

        private Map<String, String> attributes;

        private List<Entry> children;

        private Map<String, List<Entry> > selected = new HashMap<String, List<Entry> >();

        public Entry(final Element element) {
            this.element = element;
        }

        public String getName() {
            return this.element.getTagName();
        }

        public Map<String, String> getAttributes() {
            if(this.attributes != null) {
                return this.attributes;
            }

            this.attributes = new LinkedHashMap<String, String >();
            final NamedNodeMap attrs = this.element.getAttributes();

            for(int i = 0; i < attrs.getLength(); ++i ) {
                final Attr attr = (Attr)attrs.item(i);
                this.attributes.put(attr.getName(), attr.getValue());
            }

            return this.attributes;
        }

        public String getAttribute(final String attributeName) {
            final Attr attribute = this.element.getAttributeNode(attributeName);

            if (attribute == null) {
                return null;
            }

            return attribute.getValue();
        }

        public List<Entry> selectChildren(final String tagName) {

            List<Entry> children = this.selected.get(tagName);
            if ( children!=null ) {
                return children;
            }
            children = new ArrayList<Entry>();
            for( final Entry child : getChildren() ) {
                if ( child.getName().equals(tagName)) {
                    children.add(child);
                }
            }

            this.selected.put(tagName, children);

            return children;
        }

        public List<Entry> getChildren() {

            if ( this.children!=null) {
                return this.children;
            }

            this.children = new ArrayList<Entry>();
            final NodeList childNodes = this.element.getChildNodes();
            for( int i = 0; i<childNodes.getLength(); ++i) {
                final Node childNode = childNodes.item(i);
                if ( childNode instanceof Element ) {
                    this.children.add(new Entry((Element)childNode));
                }
            }

            return this.children;
        }
    }

    static class Reader {

        private final Map<String, String> constants = new LinkedHashMap<String, String>();

        public void load(final Entry configurationNode) throws IOException {


            for (final Entry constant : configurationNode.selectChildren("定数")) {
                System.out.println("constant is: " + constant.getAttribute("値"));

                constants.put( constant.getAttribute("名前"), constant.getAttribute("値") );
            }

            for (final Entry list : configurationNode.selectChildren("動作リスト")) {

                for (final Entry node : list.selectChildren("動作")) {
                    System.out.println("node name is: " + node.getName());
                }
            }

            for (final Entry list : configurationNode.selectChildren("行動リスト")) {
                System.out.println("list name is: " + list.getName());
                loadBehaviors(list, new ArrayList<String>());
            }
        }

        private void loadBehaviors(final Entry list, final List<String> conditions) {
            for (final Entry node : list.getChildren()) {

                if (node.getName().equals("条件")) {

                    final List<String> newConditions = new ArrayList<String>(conditions);
                    newConditions.add(node.getAttribute("条件"));

                    loadBehaviors(node, newConditions);

                } else if (node.getName().equals("行動")) {
                    System.out.println("action is: " + node.getName());
                }
            }
        }
    }
}
